package pl.sda.library_app.dto;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.Assert.notEmpty;

public class MakeOrderForm {
    private final Long customerId;
    private final List<BookDto> books;

    public MakeOrderForm(Long customerId, List<BookDto> books) {
        notEmpty(books, "books list is empty");
        this.customerId = requireNonNull(customerId);
        this.books = books;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeOrderForm that = (MakeOrderForm) o;
        return Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getBooks(), that.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getBooks());
    }
}