package com.example.wypozyczalnia.user;

import com.example.wypozyczalnia.assignment.AssignmentDeviceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserDto> getAllUsers(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return userService.getAllUsers();
        } else {

            return userService.getUsersByLastName(lastName);

        }
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        if(!id.equals(userDto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt musi mieć id zgodne z id w ścieżce zasobu");
        UserDto updatedUser = userService.updateUser(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    ResponseEntity<UserDto> addNewUser(@RequestBody UserDto userDto) {
        if (userDto.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zapisywany obiekt nie może mieć ustawionego id");
        } else {
            UserDto newUser = userService.createNewUser(userDto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(uri).body(newUser);
        }
    }

    @GetMapping("/{userId}/assignments")
    ResponseEntity<List<AssignmentDeviceDto>> getAllAssigments(@PathVariable Long userId){
        List<AssignmentDeviceDto> allAssigments = userService.getAllAssigments(userId);
        return ResponseEntity.ok(allAssigments);
    }


}
