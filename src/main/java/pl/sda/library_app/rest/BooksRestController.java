package pl.sda.library_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.services.BooksService;

import java.util.List;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksRestController {

    private final BooksService booksService;

    @GetMapping
    private List<Book> getAll() {
        return booksService.getAll();
    }

    @GetMapping("/{BOOK_ID}")
    private Book getById(@PathVariable("BOOK_ID") Long bookId) {
        return booksService.getById(bookId);
    }

    @DeleteMapping("/{BOOK_ID}")
    private void delete(@PathVariable("BOOK_ID") Long bookId) {
        booksService.delete(bookId);
    }

    @PostMapping
    private ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(booksService.save(book));
    }

    @PutMapping
    private Book update(@RequestBody Book book) {
        booksService.update(book);
        return book;
    }
}
