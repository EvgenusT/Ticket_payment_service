package MyProject.TicketPayment;

import MyProject.TicketPayment.Payment.PaymentProcessor;
import MyProject.TicketPayment.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketPaymentApplication implements CommandLineRunner {

    public TicketPaymentApplication(OrderRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TicketPaymentApplication.class, args);
    }

    private final  OrderRepository repository;


    @Override
    public void run(String... args) throws Exception {

        PaymentProcessor paymentProcessor = new PaymentProcessor(repository);
        paymentProcessor.go();
    }

}
