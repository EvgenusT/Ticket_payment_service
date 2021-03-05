package MyProject.TicketPayment.repository;

import MyProject.TicketPayment.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
