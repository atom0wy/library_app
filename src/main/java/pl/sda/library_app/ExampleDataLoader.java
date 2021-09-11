package pl.sda.library_app;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.enumerated.Role;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.User;
import pl.sda.library_app.repositories.BooksRepository;
import pl.sda.library_app.repositories.UserRepository;

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
        booksRepository.save(new Book("Day", "Joe", "1990", "Horror", BookStatus.IN_STOCK));
        userRepository.save(new User("Anne", "Doe", "1234", "Baker Street 123, London", "Anne.Doe@gmail.com"));
    }
}
