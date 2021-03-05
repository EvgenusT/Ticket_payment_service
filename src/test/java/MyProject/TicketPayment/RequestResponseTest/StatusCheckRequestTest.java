package MyProject.TicketPayment.RequestResponseTest;

import MyProject.TicketPayment.RequestResponse.StatusCheckRequest;
import MyProject.TicketPayment.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusCheckRequestTest {

    StatusCheckRequest statusCheckRequest = new StatusCheckRequest();

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void checkStarusOk() {

        Map<String, String> reviewRequest = new HashMap<>();
        reviewRequest.put("id", "84");
        System.out.println("вызов из теста " + reviewRequest);
        String statusOrder = statusCheckRequest.getStatusOrder(orderRepository, reviewRequest);
        assertThat(statusOrder).isEqualTo("ошибка");

    }

}