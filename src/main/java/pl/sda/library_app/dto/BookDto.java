package pl.sda.library_app.dto;

import lombok.Data;
import pl.sda.library_app.enumerated.Status;

import javax.persistence.Entity;

@Entity
@Data
public class BookDto {
    private Long id;

    private String title;
    private String author;
    private String yearOfRelease;
    private String genre;
    private Status status;
}
