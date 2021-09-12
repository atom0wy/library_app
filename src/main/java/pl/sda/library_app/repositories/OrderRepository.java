package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.library_app.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
