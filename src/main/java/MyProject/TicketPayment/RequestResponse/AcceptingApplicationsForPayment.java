package MyProject.TicketPayment.RequestResponse;

import MyProject.TicketPayment.entity.Order;
import MyProject.TicketPayment.entity.Schedule;
import MyProject.TicketPayment.repository.OrderRepository;
import MyProject.TicketPayment.repository.ScheduleRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class AcceptingApplicationsForPayment {

    public static final String STATUS_NEW = "обрабатывается";

    List<Schedule> scheduleList;

    public boolean validateNewOrder(ScheduleRepository scheduleRepository, Map<String, String> reguestMap) {

        scheduleList = scheduleRepository.findAll();
        Map<Integer, String> allscheduleMap = scheduleList.stream().collect(Collectors.toMap(str ->
                str.getNumber(), str -> str.getData()));

        return allscheduleMap.entrySet().stream().anyMatch(entry ->
                (reguestMap.get("id").equals(String.valueOf(entry.getKey())) &&
                        reguestMap.get("data").equals(entry.getValue())));
    }

    public String createNewOrder(OrderRepository orderRepository) {
        Order newOrder = new Order(STATUS_NEW);
        orderRepository.save(newOrder);
        int status = newOrder.getId();
        return String.valueOf(status);
    }
}

