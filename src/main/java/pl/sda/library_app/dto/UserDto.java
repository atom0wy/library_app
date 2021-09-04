package pl.sda.library_app.dto;

import lombok.Data;
import pl.sda.library_app.enumerated.Role;
import pl.sda.library_app.models.Book;

import java.util.ArrayList;
import java.util.List;


@Data
public class UserDto {
    private Long id;

    private String name;
    private String surname;
    private int telephoneNumber;
    private String adress;
    private String email;
    private String password;
    private Role role;
    private List<Book> booksInPossession = new ArrayList<>();
}
