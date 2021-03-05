package MyProject.TicketPayment.repository;

import MyProject.TicketPayment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Order set status = ?2 where id = ?1")
    public void updatingStatus(Integer status, String name);

    @Query(value = "SELECT COUNT (*) FROM Order")
    public int countOrders();
}
