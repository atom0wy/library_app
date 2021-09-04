package pl.sda.library_app.models;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import pl.sda.library_app.enumerated.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Book> bookList;
    private Role role;
}
