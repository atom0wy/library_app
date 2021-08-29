package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.library_app.models.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
}
