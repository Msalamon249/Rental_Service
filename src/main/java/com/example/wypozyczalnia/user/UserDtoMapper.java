package com.example.wypozyczalnia.user;


import org.springframework.stereotype.Service;

@Service
public class UserDtoMapper {
    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPesel(user.getPesel());
        return userDto;
    }

    public static User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPesel(userDto.getPesel());
        return user;
    }
}
