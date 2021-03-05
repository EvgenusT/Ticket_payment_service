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
public class Schedule {

    @Id
    @GeneratedValue
    private int number;

    @Getter
    @Setter
    private String data;

    public Schedule() {

    }

    public Schedule(String data) {
        this.data = data;
    }

}
