package com.example.wypozyczalnia.user;

import com.example.wypozyczalnia.assignment.AssignmentDeviceDto;
import com.example.wypozyczalnia.assignment.AssignmentDtoMapper;
import com.example.wypozyczalnia.exceptions.DuplicatePeselException;
import com.example.wypozyczalnia.exceptions.UserNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AssignmentDtoMapper assetDtoMapper;

    public UserService(UserRepository userRepository, AssignmentDtoMapper assetDtoMapper) {
        this.userRepository = userRepository;
        this.assetDtoMapper = assetDtoMapper;
    }

    List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDtoMapper::mapToDto).collect(Collectors.toList());
    }

    List<UserDto> getUsersByLastName(String lastName) {
        return userRepository.findAllByLastNameContainingIgnoreCase(lastName).stream().map(UserDtoMapper::mapToDto).collect(Collectors.toList());
    }

    UserDto createNewUser(UserDto userDto) {
        Optional<User> byPesel = userRepository.findByPesel(userDto.getPesel());
        byPesel.ifPresent(user -> {
            throw new DuplicatePeselException();
        });
        User toSave = UserDtoMapper.mapToEntity(userDto);
        User saved = userRepository.save(toSave);
        return UserDtoMapper.mapToDto(saved);
    }

    UserDto updateUser(UserDto userDto) {


        Optional<User> byPesel = userRepository.findByPesel(userDto.getPesel());
        byPesel.ifPresent(user -> {
            if(!user.getId().equals(userDto.getId()))
            throw new DuplicatePeselException();
        });
            User user = UserDtoMapper.mapToEntity(userDto);
            User updated = userRepository.save(user);
            return UserDtoMapper.mapToDto(updated);
        }


    UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotExistException::new);
        return UserDtoMapper.mapToDto(user);
    }
    
    List<AssignmentDeviceDto> getAllAssigments(Long id){
        User user = userRepository.findById(id).orElseThrow(UserNotExistException::new);
       return   user.getAssigments()
               .stream()
               .map(assetDtoMapper::mapToDeviceDto)
               .collect(Collectors.toList());
    }
}
