package repository;

import MyProject.TicketPayment.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    OrderRepository repository;

    @Test
    public void updatingStatus() throws Exception{
        Integer id = 9;
        String status = "ошибка";

        repository.updatingStatus(id, status);
//        assertThat();


    }
}
