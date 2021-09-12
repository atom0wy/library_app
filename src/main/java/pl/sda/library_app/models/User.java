package pl.sda.library_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import pl.sda.library_app.enumerated.Role;

import javax.annotation.security.DeclareRoles;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    private String name;
    private String lastName;
    private String password;
    private String address;
    private String email;
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Book> bookList;
    private Role role;

    public User(String name, String lastName, String password, String address, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.role = Role.USER;
    }

    public void addBook(Book book){
        List<Book> bookList = new ArrayList(this.bookList);
        bookList.add(book);
        this.setBookList(bookList);
    }
}
