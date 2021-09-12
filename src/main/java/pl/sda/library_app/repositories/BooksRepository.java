package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.Book;

import java.util.List;

public interface BooksRepository extends CrudRepository<Book, Long> {


    @Query(value = "select (count(b.BOOK_ID) > 0) from Books b where b.BOOK_ID = ?1", nativeQuery = true)
    boolean bookExists(Long bookId);

    @Query(value = "select b.* from books b where b.status = ?", nativeQuery = true)
    List<Book> findAllByStatus(BookStatus status);

    @Query(value = "select b.* from books b where b.status in ('IN_STOCK')", nativeQuery = true)
    List<Book> fetchAvailableBooks();
}
