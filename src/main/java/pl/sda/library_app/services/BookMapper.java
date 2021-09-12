package pl.sda.library_app.services;

import org.springframework.stereotype.Service;
import pl.sda.library_app.dto.BookDto;
import pl.sda.library_app.models.Book;

@Service
public class BookMapper {
    public Book mapDtoToEntity(BookDto bookDto) {
        Book bookEntity = new Book();
        if (bookDto != null) {
            if (bookDto.getTitle() != null) {
                bookEntity.setTitle(bookDto.getTitle());
            }

            if (bookDto.getAuthor() != null) {
                bookEntity.setAuthor(bookDto.getAuthor());
            }

            if (bookDto.getYearOfRelease() != null) {
                bookEntity.setYearOfRelease(bookDto.getYearOfRelease());
            }
            if (bookDto.getGenre() != null) {
                bookEntity.setGenre(bookDto.getGenre());
            }
            if (bookDto.getStatus() != null) {
                bookEntity.setStatus(bookDto.getStatus());
            }
        }
        return bookEntity;
    }
}
