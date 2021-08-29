package pl.sda.library_app.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private int telephoneNumber;
    private String adress;
    private String email;
    private String password;
    private List<Book> booksInPossession = new ArrayList<>();
    private Role role;
}
