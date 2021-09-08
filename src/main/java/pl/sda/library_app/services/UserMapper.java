package pl.sda.library_app.services;

import pl.sda.library_app.dto.UserDto;
import pl.sda.library_app.models.User;

public class UserMapper {
    public User mapDtoToEntity(UserDto userDto) {
        User userEntity = new User();
        if (userDto != null) {
            if (userDto.getName() != null) {
                userEntity.setName(userDto.getName());
            }
            if (userDto.getLastName() != null) {
                userEntity.setLastName(userDto.getLastName());
            }
            if (userDto.getPassword() != null) {
                userEntity.setPassword(userDto.getPassword());
            }
            if (userDto.getAdress() != null) {
                userEntity.setAddress(userDto.getAdress());
            }
            if (userDto.getEmail() != null) {
                userEntity.setEmail(userDto.getEmail());
            }
        }
        return userEntity;
    }
}
