package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.library_app.models.User;

public interface CustomerRepository extends JpaRepository<User, Long> {
}
