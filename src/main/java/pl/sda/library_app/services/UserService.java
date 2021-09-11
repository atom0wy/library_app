package pl.sda.library_app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.library_app.dto.UserDto;
import pl.sda.library_app.enumerated.Role;
import pl.sda.library_app.exceptions.EmailAlreadyExistsException;
import pl.sda.library_app.exceptions.UserDoesNotExistException;
import pl.sda.library_app.models.User;
import pl.sda.library_app.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserDto userDto) throws EmailAlreadyExistsException {

        if (userRepository.emailExist(userDto.getEmail())) {
            throw new EmailAlreadyExistsException
                    ("An account already exists with provided email adress: " + userDto.getEmail());
        }
        User user = new User();

        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAdress());
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserDoesNotExistException("User does not exist")
        );
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        if (userRepository.findById(user.getId()).isEmpty()) {
            throw new UserDoesNotExistException("User does not exists");
        }
        userRepository.save(user);
    }
}
