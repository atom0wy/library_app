package pl.sda.library_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.User;
import pl.sda.library_app.services.UserService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/users")
    private List<User> getAll() {
        return userService.getAll();
    }
/*
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
    }*/
}