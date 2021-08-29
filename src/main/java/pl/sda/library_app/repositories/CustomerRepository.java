package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.library_app.models.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
