package pl.sda.library_app.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.exceptions.BookDoesNotExistException;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.repositories.BooksRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BooksServiceTest extends BaseServiceTest {

    @Autowired
    private BooksService booksService;

    @Autowired
    private BooksRepository booksRepository;

    @Test
    void shouldNotUpdateBookThatDoesNotExist() {
        // given
        final var book = new Book(1234L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book2 = new Book(12345L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book3 = new Book(12346L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book4 = new Book(12347L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book5 = new Book(12348L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book6 = new Book(123489L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);

        // when
        booksRepository.save(book);
        booksRepository.save(book2);
        booksRepository.save(book3);
        booksRepository.save(book4);
        booksRepository.save(book5);

        // then
        assertThrows(BookDoesNotExistException.class, () -> booksService.update(book6));
    }

    @Test
    void shouldUpdateBook() {
        // given
        final var book = new Book(1234L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book2 = new Book(12345L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book3 = new Book(12346L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book4 = new Book(12347L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book5 = new Book(12348L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);
        final var book6 = new Book(12345L, "Night123", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);

        // when
        booksRepository.save(book);
        booksRepository.save(book2);
        booksRepository.save(book3);
        booksRepository.save(book4);
        booksRepository.save(book5);
        booksService.update(book6);

        // then
        assertEquals(booksRepository.findById(12345L).get().getTitle(), book6.getTitle());
//        assertEquals(booksService.getById(12345L).getTitle(), book6.getTitle());
    }

}