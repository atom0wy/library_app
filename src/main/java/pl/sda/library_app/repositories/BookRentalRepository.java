package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.library_app.models.BookRental;

import java.util.UUID;

public interface BookRentalRepository extends JpaRepository<BookRental, UUID> {
}
