package pl.sda.library_app.models;

import lombok.Data;
import pl.sda.library_app.enumerated.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private int telephoneNumber;
    private String address;
    private String email;
    private String password;
    private List<Book> booksInPossession = new ArrayList<>();
    private Role role;
}
