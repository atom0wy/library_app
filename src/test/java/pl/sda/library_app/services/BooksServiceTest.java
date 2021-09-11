package pl.sda.library_app.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.exceptions.BookDoesNotExistException;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.repositories.BooksRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BooksServiceTest {

    @Autowired
    private BooksService booksService;

    @Autowired
    private BooksRepository booksRepository;

    @Test
    void shouldNotUpdateBookThatDoesNotExist() {
        // given
        final var book6 = new Book(12345L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);

        // when

        // then
        final var bookCount = booksRepository.count();
        assertThrows(BookDoesNotExistException.class, () -> booksService.update(book6));
        assertEquals(bookCount, booksRepository.count());
    }

    @Test
    void shouldUpdateBook() {
        // given
        final var book = new Book("Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book1 = new Book(2L, "Night123", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);

        // when
        booksRepository.save(book);
        booksService.update(book1);


        // then
        assertEquals(booksRepository.findById(2L).get().getTitle(), book1.getTitle());
    }

    @Test
    void shouldFindExistingBook() {
        // given
        Book book = new Book("Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);

        // when
        booksRepository.save(book);

        // then
        assertEquals(true, booksRepository.existsById(2L));
    }

}