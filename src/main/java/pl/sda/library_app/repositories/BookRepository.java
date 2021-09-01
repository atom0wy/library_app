package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.Book;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select distinct b.name from book b order by b.name", nativeQuery = true)
    List<Book> listAllUniqueBookTitles();

    @Query(value = "select distinct b.author from book b order by b.author", nativeQuery = true)
    List<Book> listAllUniqueBookAuthors();

    @Query(value = "select o.* from orders o where o.status = ?", nativeQuery = true)
    List<Book> countBooksInInStockStatus(BookStatus status);
}
