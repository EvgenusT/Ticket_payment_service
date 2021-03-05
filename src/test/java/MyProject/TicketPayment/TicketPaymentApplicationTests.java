package MyProject.TicketPayment;

import MyProject.TicketPayment.entity.Order;
import MyProject.TicketPayment.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class TicketPaymentApplicationTests {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void findByID() throws Exception {

        Optional<Order> orderList = orderRepository.findById(42);
        assertThat(orderList);
    }

    @Test
    public void findAllOrdersByStatus(){
//        List<Order> orders = orderRepository.findAllOrdersByStatus();

    }

}
