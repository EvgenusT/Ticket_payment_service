package MyProject.TicketPayment.controller;

import MyProject.TicketPayment.RequestResponse.AcceptingApplicationsForPayment;
import MyProject.TicketPayment.RequestResponse.StatusCheckRequest;
import MyProject.TicketPayment.repository.OrderRepository;
import MyProject.TicketPayment.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ticketPyment")
public class TicketPaymentController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    AcceptingApplicationsForPayment acceptingApplicationsForPayment = new AcceptingApplicationsForPayment();

    @PostMapping("order")
    public Map<String, String> receiveRequestByOrder(@RequestBody Map<String, String> reguestMap) throws IOException {
        String idOrder = "";
        Map<String, String> jsonResponse = new HashMap<>();

        if (acceptingApplicationsForPayment.validateNewOrder(scheduleRepository, reguestMap)) {
            idOrder = acceptingApplicationsForPayment.createNewOrder(orderRepository);
            jsonResponse.put("id", idOrder);
            return jsonResponse;
        }
        return null;
    }

    @PostMapping("checkOrder")
    public Map<String, String> checkingStatusOfApplication(@RequestBody Map<String, String> reviewRequest) throws IOException {
        StatusCheckRequest statusCheckRequest = new StatusCheckRequest();
        String statusreceived = statusCheckRequest.getStatusOrder(orderRepository, reviewRequest);

        Map<String, String> statusOrder = new HashMap<>();
        statusOrder.put("status", statusreceived);

        return statusOrder;

    }
}


