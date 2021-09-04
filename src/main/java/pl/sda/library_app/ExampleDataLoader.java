package pl.sda.library_app;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.repositories.BooksRepository;

@Component
class ExampleDataLoader {

    private final BooksRepository repository;

    ExampleDataLoader(BooksRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @EventListener
    public void onApplicationLoad(ApplicationReadyEvent event) {
        repository.save(new Book(12345L, "Night", "Joe", "1990", "Horror", BookStatus.IN_STOCK));
    }
}
