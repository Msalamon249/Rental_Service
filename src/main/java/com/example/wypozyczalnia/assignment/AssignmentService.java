package com.example.wypozyczalnia.assignment;

import com.example.wypozyczalnia.assets.Asset;
import com.example.wypozyczalnia.assets.AssetRepository;
import com.example.wypozyczalnia.exceptions.*;
import com.example.wypozyczalnia.user.User;
import com.example.wypozyczalnia.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;
    private final AssignmentDtoMapper assignmentDtoMapper;
    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssetRepository assetRepository, UserRepository userRepository, AssignmentDtoMapper assignmentDtoMapper, AssignmentRepository assignmentRepository) {
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
        this.assignmentDtoMapper = assignmentDtoMapper;
        this.assignmentRepository = assignmentRepository;
    }

    public AssignmentDto save(AssignmentDto assignmentDto) {
        assignmentRepository.findByAsset_IdAndEndBorrowIsNull(assignmentDto.getAssetId()).ifPresent(assignment -> {
            throw new InvalidAssignmentException(" To wyposażenie jest aktualnie do kogoś przypisane");
        });
        Optional<User> UserById = userRepository.findById(assignmentDto.getUserId());
        Optional<Asset> AssetById = assetRepository.findById(assignmentDto.getAssetId());

        Assignment assignment = new Assignment();
        assignment.setUser(UserById.orElseThrow(() -> new InvalidAssignmentException("Brak użytownika o wskazanym id")));
        assignment.setAsset(AssetById.orElseThrow(() -> new InvalidAssignmentException("Brak wyposażenia o wskazanym id")));
        assignment.setStartBorrow(LocalDateTime.now());

        return assignmentDtoMapper.mapToAssignmentDto(assignmentRepository.save(assignment));
    }

    @Transactional
    public LocalDateTime returnAsset(Long assingmentId) {
        Assignment assignment = assignmentRepository.findById(assingmentId).orElseThrow(AssignmentNotExistException::new);
        if (assignment.getEndBorrow() != null) {
            throw new AssignmentAlreadyFinishedException();
        }
        assignment.setEndBorrow(LocalDateTime.now());

        return assignment.getEndBorrow();
    }
}
