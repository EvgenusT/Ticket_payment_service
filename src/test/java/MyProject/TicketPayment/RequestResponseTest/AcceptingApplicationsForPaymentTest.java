package MyProject.TicketPayment.RequestResponseTest;

import MyProject.TicketPayment.RequestResponse.AcceptingApplicationsForPayment;
import MyProject.TicketPayment.repository.OrderRepository;
import MyProject.TicketPayment.repository.ScheduleRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcceptingApplicationsForPaymentTest {

    AcceptingApplicationsForPayment acceptingApplicationsForPayment = new AcceptingApplicationsForPayment();

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    @Test
    public void validateNewOrder_OK() {

        Map<String, String> reguestMap = new HashMap<>();
        reguestMap.put("id", "1");
        reguestMap.put("data", "2021-03-03 09:00:00");

        boolean b = acceptingApplicationsForPayment.validateNewOrder(scheduleRepository, reguestMap);
        assertThat(b).isTrue();
    }

    @Test
    public void validateNewOrder_NotOK() {

        Map<String, String> reguestMap = new HashMap<>();
        reguestMap.put("id", "2");
        reguestMap.put("data", "2021-03-03 09:00:00");

        boolean b = acceptingApplicationsForPayment.validateNewOrder(scheduleRepository, reguestMap);
        assertThat(b).isFalse();
    }

    //данный тест создает новую заявку и проверяет по ID
    @Test
    public void createNewOrder_OK() {

        orderRepository.countOrders();
        Integer statusTest = orderRepository.countOrders() + 1;
        String newOrder = acceptingApplicationsForPayment.createNewOrder(orderRepository);
        assertThat(newOrder).isEqualTo(statusTest.toString());
    }
}
