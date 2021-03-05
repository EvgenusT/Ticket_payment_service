package MyProject.TicketPayment.RequestResponse;

import MyProject.TicketPayment.entity.Order;
import MyProject.TicketPayment.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

public class StatusCheckRequest {

    public String getStatusOrder(OrderRepository orderRepository, Map<String, String> reviewRequest) throws EntityNotFoundException {
        int idOrder = Integer.parseInt(reviewRequest.get("id"));
        Order order = orderRepository.getOne(idOrder);
        String orderStatus = order.getStatus();
        return orderStatus;
    }
}
