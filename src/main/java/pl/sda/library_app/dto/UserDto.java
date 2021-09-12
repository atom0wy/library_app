package pl.sda.library_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.library_app.enumerated.Role;
import pl.sda.library_app.models.Book;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String name;
    private String lastName;
    private String adress;
    private String email;
    private String password;
    private Role role;

    public UserDto(String name, String lastName, String adress, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
    }
}
