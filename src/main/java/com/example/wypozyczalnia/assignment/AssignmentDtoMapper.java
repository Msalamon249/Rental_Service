package com.example.wypozyczalnia.assignment;

import com.example.wypozyczalnia.assets.Asset;
import com.example.wypozyczalnia.assets.AssetRepository;
import com.example.wypozyczalnia.user.User;
import com.example.wypozyczalnia.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignmentDtoMapper {
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;

    public AssignmentDtoMapper(UserRepository userRepository, AssetRepository assetRepository) {
        this.userRepository = userRepository;
        this.assetRepository = assetRepository;
    }

    public AssignmentDeviceDto mapToDeviceDto(Assignment assigments) {
        AssignmentDeviceDto assigmentDto = new AssignmentDeviceDto();
        assigmentDto.setId(assigments.getId());
        assigmentDto.setStartBorrow(assigments.getStartBorrow());
        assigmentDto.setEndBorrow(assigments.getEndBorrow());
        Asset asset = assigments.getAsset();
        assigmentDto.setAssetId(asset.getId());
        assigmentDto.setAssetName(asset.getName());
        assigmentDto.setAssetSerialNumber(asset.getSerialNumber());
        return assigmentDto;

    }


    public AssignmentUserDto mapToUserDto(Assignment assignment) {
        AssignmentUserDto assignmentUserDto = new AssignmentUserDto();
        assignmentUserDto.setId(assignment.getId());
        assignmentUserDto.setStartBorrow(assignment.getStartBorrow());
        assignmentUserDto.setEndBorrow(assignment.getEndBorrow());
        User user = assignment.getUser();

        assignmentUserDto.setUserId(user.getId());
        assignmentUserDto.setUserName(user.getFirstName());
        assignmentUserDto.setUserLastName(user.getLastName());
        assignmentUserDto.setUserPesel(user.getPesel());
        return assignmentUserDto;
    }

    public AssignmentDto mapToAssignmentDto(Assignment assignment) {
        AssignmentDto dto = new AssignmentDto();
        User user = assignment.getUser();
        dto.setId(assignment.getId());
        dto.setStartBorrow(assignment.getStartBorrow());
        dto.setEndBorrow(assignment.getEndBorrow());
        dto.setUserId(user.getId());
        Asset asset = assignment.getAsset();
        dto.setAssetId(asset.getId());
        return dto;
    }


}
