package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from orders o where o.status = ?", nativeQuery = true)
    List<Book> findAllByStatus(BookStatus status);

    @Query(value = "select o.* from orders o where o.status in ('LENT', 'RESERVED')", nativeQuery = true)
    List<Book> fetchOrdersInProcessing();

    @Query(value = "select distinct b.name from book b order by b.name where o.status in ('LENT', 'RESERVED')", nativeQuery = true)
    List<Book> listAllUniqueBookTitlesFromOrders();

    @Query(value = "select distinct b.author from book b order by b.author where o.status in ('LENT', 'RESERVED')", nativeQuery = true)
    List<Book> listAllUniqueBookAuthorsFromOrders();
}
