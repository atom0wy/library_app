package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sda.library_app.models.Book;

import java.util.UUID;

//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Book, Long> {

    @Query(value = "select b.* from books b where b.bookId = ?", nativeQuery = true)
    boolean bookExists(Long bookId);
}
