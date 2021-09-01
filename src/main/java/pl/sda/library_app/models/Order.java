package pl.sda.library_app.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Book> bookList;

    private LocalDateTime rentDate;
    private LocalDateTime mandatoryReturnDate;

    public Order() {
    }

    public Order(Long userId, List<Book> bookList) {
        notNull(userId, "User Id is null");
        notEmpty(bookList, "Books list is empty");
        this.userId = userId;
        this.bookList = bookList;
        this.rentDate = LocalDateTime.now();
        this.mandatoryReturnDate = rentDate.plus(2, ChronoUnit.WEEKS);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public LocalDateTime getMandatoryReturnDate() {
        return mandatoryReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(userId, order.userId) && Objects.equals(bookList, order.bookList) && Objects.equals(rentDate, order.rentDate) && Objects.equals(mandatoryReturnDate, order.mandatoryReturnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, bookList, rentDate, mandatoryReturnDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookList=" + bookList +
                ", rentDate=" + rentDate +
                ", mandatoryReturnDate=" + mandatoryReturnDate +
                '}';
    }
}
