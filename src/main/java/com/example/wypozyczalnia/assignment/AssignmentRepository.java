package com.example.wypozyczalnia.assignment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {

    Optional<Assignment> findByAsset_IdAndEndBorrowIsNull(Long assetId);

}
