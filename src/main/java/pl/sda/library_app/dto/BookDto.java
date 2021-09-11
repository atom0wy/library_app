package pl.sda.library_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sda.library_app.enumerated.BookStatus;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
public class BookDto {
    private Long id;

    private String title;
    private String author;
    private String yearOfRelease;
    private String genre;
    private BookStatus status;

    public BookDto(String title, String author, String yearOfRelease, String genre, BookStatus status) {
        this.title = title;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.status = status;
    }
}
