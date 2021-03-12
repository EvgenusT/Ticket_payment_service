package MyProject.TicketPayment.Payment;

import MyProject.TicketPayment.entity.Order;
import MyProject.TicketPayment.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class PaymentProcessor {

    private final OrderRepository repository;

    public static final String STATUS_NEW = "обрабатывается";
    public static final String STATUS_ERROR = "ошибка";
    public static final String STATUS_COMPLETED = "проведен";

    public PaymentProcessor(OrderRepository repository) {
        this.repository = repository;
    }

    public void go() {

        Thread run = new Thread(() -> {
            while (true) {
                try {
                    //получил список с рандомным статусом. Изначально были все "обрабатывается"
                    payment(getllOrdersForPay());

                    Thread.sleep(60000);

                } catch (InterruptedException ignored) {
                }
            }
        });
        run.start();
    }

    private List<Order> getllOrdersForPay() {
        List<Order> ordersAllList = repository.findAll();
        List<Order> listOrdersForPayment = ordersAllList.stream().filter(str -> str.getStatus().equals("обрабатывается")).collect(Collectors.toList());
        listOrdersForPayment.stream().collect(Collectors.toMap(Order::getId, Order::getStatus));
        return listOrdersForPayment;
    }

    private void payment(List<Order> forPay) {
        //тут происходит оплата и возвращаются платежи с новыми статусами
        //.......
        Map<Integer, String> ordersForPay = forPay.stream().collect(Collectors.toMap(Order::getId, Order::getStatus));
        ordersForPay.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, str ->
                str.setValue(randomStatusAssignment()))).entrySet().stream().filter(str ->
                str.getValue().equals("проведен") || str.getValue().equals("ошибка")).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // обновление статусов после оплаты а базе
        for (Map.Entry<Integer, String> pair : ordersForPay.entrySet()) {
            repository.updatingStatus(pair.getKey(), pair.getValue());
        }
    }

    private String randomStatusAssignment() {
        List<String> randomList = new ArrayList<>();
        randomList.add(STATUS_NEW);
        randomList.add(STATUS_COMPLETED);
        randomList.add(STATUS_ERROR);

        Random rand = new Random();
        int res = rand.nextInt(randomList.size());

        return randomList.get(res);
    }
}

