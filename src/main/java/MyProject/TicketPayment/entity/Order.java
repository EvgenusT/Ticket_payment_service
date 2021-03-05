package MyProject.TicketPayment.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @Getter
    @Setter
    private String status;

    public Order() {
    }

    public Order(String status) {
        this.status = status;
    }
}
