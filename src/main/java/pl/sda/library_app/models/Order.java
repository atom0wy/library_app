package pl.sda.library_app.models;

import lombok.NoArgsConstructor;
import pl.sda.library_app.enumerated.BookStatus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Book book;

    private LocalDateTime rentDate;
    private LocalDateTime mandatoryReturnDate;

    public Order(Long userId, Book book) {
        notNull(userId, "User Id is null");
        notNull(book, "Book is null");
        this.userId = userId;
        book.setStatus(BookStatus.LENT);
        this.book = book;
        this.rentDate = LocalDateTime.now();
        this.mandatoryReturnDate = rentDate.plus(2, ChronoUnit.WEEKS);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Book getBook() {
        return book;
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
        return Objects.equals(id, order.id) && Objects.equals(userId, order.userId) && Objects.equals(book, order.book) && Objects.equals(rentDate, order.rentDate) && Objects.equals(mandatoryReturnDate, order.mandatoryReturnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, book, rentDate, mandatoryReturnDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookList=" + book +
                ", rentDate=" + rentDate +
                ", mandatoryReturnDate=" + mandatoryReturnDate +
                '}';
    }
}
