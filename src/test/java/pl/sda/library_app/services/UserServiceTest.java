package pl.sda.library_app.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.library_app.dto.UserDto;
import pl.sda.library_app.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldRegisterNewUser() {
        // given
        final var userDto = new UserDto("Tom", "Train", "TrainStation street 10, Borton", "TomTheTrain@gmail.com", "password");

        // when
        userService.registerUser(userDto);

        // then
        assertEquals(userRepository.findById(2L).get().getName(), userDto.getName());
    }


}