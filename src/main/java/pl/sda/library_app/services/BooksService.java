package pl.sda.library_app.services;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import pl.sda.library_app.exceptions.BookAlreadyExistsException;
import pl.sda.library_app.exceptions.BookDoesNotExistsException;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.repositories.BooksRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

//defining the business logic
@Service
public class BooksService {

    BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository){
        this.booksRepository = requireNonNull(booksRepository);
    }

    //getting all books record by using the method findAll() of CrudRepository
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        booksRepository.findAll().forEach(bookList::add);
        return bookList;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Book getBooksById(Long id) {
        return booksRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void save(Book book) {
        if (booksRepository.findById(book.getId()).isPresent()) {
            throw new BookAlreadyExistsException("Book already exists: " + book.getId());
        }
        booksRepository.save(book);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id) {
        booksRepository.deleteById(id);
    }

    //updating a record
    public void update(Book book) {
        if (booksRepository.findById(book.getId()).isEmpty()) {
            throw new BookDoesNotExistsException("Book does not exists: " + book.getId());
        }
        booksRepository.save(book);
    }
}
