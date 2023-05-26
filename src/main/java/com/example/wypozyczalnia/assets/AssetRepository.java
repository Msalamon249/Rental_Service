package com.example.wypozyczalnia.assets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface AssetRepository extends JpaRepository<Asset,Long> {
    Asset findByName(String name);
    Optional<Asset> findBySerialNumber(String serialNumber);
    @Query("SELECT a FROM Asset a WHERE LOWER(a.name)  LIKE LOWER(concat('%', :search, '%'))" +
            "OR LOWER(a.serialNumber) LIKE LOWER(concat('%', :search, '%'))")
    List<Asset> findAllBySerialNumberOrName(@Param("search") String search);
}
