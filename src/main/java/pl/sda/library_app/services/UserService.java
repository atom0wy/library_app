package pl.sda.library_app.services;

import lombok.RequiredArgsConstructor;
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

    private final UserRepository customerRepository;

    private PasswordEncoder passwordEncoder;

    public User registerNewUserAccount(UserDto accountDto) throws EmailAlreadyExistsException {

        if (customerRepository.emailExist(accountDto.getEmail())) {
            throw new EmailAlreadyExistsException
                    ("There is an account with that email adress: " + accountDto.getEmail());
        }
        User user = new User();

        user.setName(accountDto.getName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setAddress(accountDto.getAdress());
        user.setRole(Role.USER);

        return customerRepository.save(user);
    }

    public List<User> getAll() {
        return new ArrayList<>(customerRepository.findAll());
    }

    public User getById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new UserDoesNotExistException("User does not exist: " + id)
        );
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public void update(User user) {
        if (customerRepository.findById(user.getId()).isEmpty()) {
            throw new UserDoesNotExistException("User does not exists: " + user.getId());
        }
        customerRepository.save(user);
    }
}
