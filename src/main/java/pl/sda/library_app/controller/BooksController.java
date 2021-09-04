package pl.sda.library_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.services.BooksService;

import java.util.List;

//mark class as Controller
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping
    private List<Book> getAll() {
        return booksService.getAll();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/{BOOK_ID}")
    private Book getById(@PathVariable("BOOK_ID") Long bookId) {
        return booksService.getById(bookId);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/{BOOK_ID}")
    private void delete(@PathVariable("BOOK_ID") Long bookId) {
        booksService.delete(bookId);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping
    private Long save(@RequestBody Book book) {
        booksService.save(book);
        return book.getId();
    }

    //creating put mapping that updates the book detail
    @PutMapping
    private Book update(@RequestBody Book book) {
        booksService.update(book);
        return book;
    }
}
