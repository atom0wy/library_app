package pl.sda.library_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sda.library_app.enumerated.BookStatus;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class BookDto {
    private Long id;

    private String title;
    private String author;
    private String yearOfRelease;
    private String genre;
    private BookStatus status;
}
