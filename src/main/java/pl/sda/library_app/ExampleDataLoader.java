package pl.sda.library_app;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.User;
import pl.sda.library_app.repositories.BooksRepository;
import pl.sda.library_app.repositories.UserRepository;

import java.util.List;

@Component
class ExampleDataLoader {

    private final BooksRepository booksRepository;
    private final UserRepository userRepository;

    ExampleDataLoader(BooksRepository booksRepository, UserRepository userRepository) {
        this.booksRepository = booksRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @EventListener
    public void onApplicationLoad(ApplicationReadyEvent event) {
        User user = new User("Mark", "Stev", "1234", "Broken Street 123, London", "Mark.Stev@gmail.com");
        User user1 = new User("Anne", "Doe", "1234", "Baker Street 123, London", "Anne.Doe@gmail.com");
        Book book = new Book("Midnight", "Joe", "1990", "Horror", BookStatus.IN_STOCK);
        Book book1 = new Book("Daylight", "Jack", "2000", "Comedy", BookStatus.IN_STOCK);
        Book book2 = new Book("Dusk", "Jeff", "2005", "Fantasy", BookStatus.IN_STOCK);
        Book book3 = new Book("Dawn", "Joel", "2001", "Historical", BookStatus.IN_STOCK);
        Book book4 = new Book("Sorrow", "Marry", "1980", "Horror", BookStatus.IN_STOCK);
        user.setBookList(List.of(book, book2, book3));
        user1.setBookList(List.of(book4, book1));
        userRepository.save(user);
        userRepository.save(user1);
//        booksRepository.save(new Book("Day", "Joe", "1990", "Horror", BookStatus.IN_STOCK));
//        userRepository.save(new User("Anne", "Doe", "1234", "Baker Street 123, London", "Anne.Doe@gmail.com"));
    }
}
