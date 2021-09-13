package pl.sda.library_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.library_app.dto.UserDto;
import pl.sda.library_app.models.User;
import pl.sda.library_app.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/users/all")
    private List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{USER_ID}")
    private User getById(@PathVariable("USER_ID") Long userId) {
        return userService.getById(userId);
    }

    @DeleteMapping("/users/{USER_ID}")
    private void delete(@PathVariable("USER_ID") Long userId) {
        userService.delete(userId);
    }

//    @PostMapping("/register")
//    private ResponseEntity<User> save(@RequestBody UserDto user) {
//        return ResponseEntity.ok(userService.registerUser(user));
//    }
//
//    @PutMapping
//    private User update(@RequestBody User user) {
//        userService.update(user);
//        return user;
//    }
}