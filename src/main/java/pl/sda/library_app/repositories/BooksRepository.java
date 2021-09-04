package pl.sda.library_app.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sda.library_app.models.Book;

//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Book, Long> {
}
