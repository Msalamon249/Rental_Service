package com.example.wypozyczalnia.assignment;

import com.example.wypozyczalnia.exceptions.InvalidAssignmentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    ResponseEntity<AssignmentDto> save(@RequestBody AssignmentDto assignmentDto) {
        AssignmentDto savedAssignment;
        try {
            savedAssignment = assignmentService.save(assignmentDto);
        } catch (InvalidAssignmentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAssignment.getId()).toUri();
        return ResponseEntity.created(uri).body(savedAssignment);
    }

    @PostMapping("/{assignmentId}/end")
    ResponseEntity returnAsset(@PathVariable Long assignmentId) {
        LocalDateTime endDate = assignmentService.returnAsset(assignmentId);
        return ResponseEntity.accepted().body(endDate);
    }
}
