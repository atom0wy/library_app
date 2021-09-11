package pl.sda.library_app.services;

import org.springframework.stereotype.Service;
import pl.sda.library_app.exceptions.BookDoesNotExistException;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.repositories.BooksRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;


@Service
public class BooksService {

    BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository){
        this.booksRepository = requireNonNull(booksRepository);
    }


    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        booksRepository.findAll().forEach(bookList::add);
        return bookList;
    }


    public Book getById(Long id) {
        return booksRepository.findById(id).orElseThrow(
                () -> new BookDoesNotExistException("Book does not exists: " + id)
        );
    }


    public Book save(Book book) {
        return booksRepository.save(book);
    }


    public void delete(Long id) {
        booksRepository.deleteById(id);
    }


    public void update(Book book) {
        if (getById(book.getId()).equals(book)){
            throw new BookDoesNotExistException("Book does not exists: " + book.getId());
        }
//        if (booksRepository.findById(book.getId()).isEmpty()) {
//            throw new BookDoesNotExistException("Book does not exists: " + book.getId());
//        }
        booksRepository.save(book);
    }
}
