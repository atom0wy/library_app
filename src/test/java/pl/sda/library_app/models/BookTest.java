package pl.sda.library_app.models;

import org.junit.jupiter.api.Test;
import pl.sda.library_app.enumerated.BookStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest extends EntityBaseTest {

    @Test
    void shouldSaveBookInDatabase() {
        // given
        final var book = new Book(1234L, "Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);

        // when
        persistAndClearCache(book);

        // then
        final var readBook = em.find(Book.class, book.getId());
        assertEquals(readBook, book);

    }
}