package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.BookRental;
import pl.sda.library_app.models.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o.* from orders o where o.status = ?")
    List<Book> findAllByStatus(BookStatus status);

    @Query("select o.* from orders o where o.status in ('LENT', 'RESERVED')")
    List<Book> fetchOrdersInProcessing();

    @Query("select o.* from orders o where o.status = IN_STOCK")
    List<Book> countOrdersInInStockStatus();

    @Query("select distinct b.name from book b order by b.name")
    List<Book> listAllUniqueBookTitles();

    @Query("select distinct b.author from book b order by b.author")
    List<Book> listAllUniqueBookAuthors();
}
