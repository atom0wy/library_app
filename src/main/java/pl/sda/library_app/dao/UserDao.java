package pl.sda.library_app.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERS")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CUSTOMER_NAME")
    private String name;
    @Column(name="CUSTOMER_LAST_NAME")
    private String surname;
    @Column(name="CUSTOMER_PHONE_NUMBER")
    private int telephoneNumber;
    @Column(name="CUSTOMER_ADRESS")
    private String adress;
    @Column(name="CUSTOMER_EMAIL")
    private String email;
    @Column(name="CUSTOMER_PW")
    private String password;
    @Column(name="USER_ROLE")
    private Role role;
    @Column(name="CUSTOMER_BOOKS")
    @OneToMany
    private List<Book> booksInPossession = new ArrayList<>();

    public UserDao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Book> getBooksInPossession() {
        return booksInPossession;
    }

    public void setBooksInPossession(List<Book> booksInPossession) {
        this.booksInPossession = booksInPossession;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", booksInPossession=" + booksInPossession +
                '}';
    }
}
