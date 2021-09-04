package pl.sda.library_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.library_app.enumerated.BookStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "bookId")
    private Long id;

    private String title;
    private String author;
    private String yearOfRelease;
    private String genre;
    private BookStatus status;
}
