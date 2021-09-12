package pl.sda.library_app.dto;

import pl.sda.library_app.models.Book;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;

public class MakeOrderForm {
    private final Long customerId;
    private final BookDto book;

    public MakeOrderForm(Long customerId, BookDto book) {
        notNull(book, "book is null");
        this.customerId = requireNonNull(customerId);
        this.book = book;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public BookDto getBook() {
        return book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeOrderForm that = (MakeOrderForm) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, book);
    }
}