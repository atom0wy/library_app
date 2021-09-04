package pl.sda.library_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.services.BooksService;

import java.util.List;

//mark class as Controller
@RestController
public class BooksController {
    //autowire the BooksService class
    @Autowired
    BooksService booksService;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/books")
    private List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/books/{bookId}")
    private Book getBooks(@PathVariable("bookId") Long bookId) {
        return booksService.getBooksById(bookId);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/books/{bookId}")
    private void deleteBook(@PathVariable("bookId") Long bookId) {
        booksService.delete(bookId);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private Long saveBook(@RequestBody Book book) {
        booksService.saveOrUpdate(book);
        return book.getId();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Book update(@RequestBody Book book) {
        booksService.saveOrUpdate(book);
        return book;
    }
}
