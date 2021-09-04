package pl.sda.library_app.services;

import org.springframework.stereotype.Service;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.repositories.BooksRepository;

import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class BooksService {

    BooksRepository booksRepository;

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
    public void saveOrUpdate(Book book) {
        booksRepository.save(book);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id) {
        booksRepository.deleteById(id);
    }

    //updating a record
    public void update(Book book, Long bookId) {
        booksRepository.save(book);
    }
}
