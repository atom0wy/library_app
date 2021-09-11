package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sda.library_app.models.Book;

public interface BooksRepository extends CrudRepository<Book, Long> {


@Query(value = "select (count(b.BOOK_ID) > 0) from Books b where b.BOOK_ID = ?1", nativeQuery = true)
    boolean bookExists(Long bookId);
}
