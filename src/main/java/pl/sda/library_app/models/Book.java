package pl.sda.library_app.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.library_app.enumerated.BookStatus;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String yearOfRelease;
    private String genre;
    private BookStatus status;

    public Book(String title, String author, String yearOfRelease, String genre, BookStatus status) {
        this.title = title;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.status = status;
    }

    public Book(Long id, String title, String author, String yearOfRelease, String genre, BookStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.status = status;
    }

}
