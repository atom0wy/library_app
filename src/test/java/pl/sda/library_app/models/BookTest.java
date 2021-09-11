package pl.sda.library_app.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.repositories.BooksRepository;
import pl.sda.library_app.services.BooksService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookTest {

    @Autowired
    private BooksService booksService;

    @Autowired
    private BooksRepository booksRepository;

    @Test
    void shouldSaveBookInDatabase() {
        // given
        final var book = new Book("Night", "Joe Doe", "2000", "Horror", BookStatus.IN_STOCK);

        // when
        booksRepository.save(book);

        // then
        Book readBook = new Book();
        if(booksRepository.findById(2L).isPresent()) {
            readBook = booksRepository.findById(2L).get();
        }
        assertEquals(readBook, book);

    }
}