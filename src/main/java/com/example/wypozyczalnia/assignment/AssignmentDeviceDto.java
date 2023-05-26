package com.example.wypozyczalnia.assignment;

import java.time.LocalDateTime;

public class AssignmentDeviceDto {

    private Long id;
    private LocalDateTime startBorrow;
    private LocalDateTime endBorrow;
    private Long assetId;
    private String assetName;
    private String assetSerialNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartBorrow() {
        return startBorrow;
    }

    public void setStartBorrow(LocalDateTime startBorrow) {
        this.startBorrow = startBorrow;
    }

    public LocalDateTime getEndBorrow() {
        return endBorrow;
    }

    public void setEndBorrow(LocalDateTime endBorrow) {
        this.endBorrow = endBorrow;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetSerialNumber() {
        return assetSerialNumber;
    }

    public void setAssetSerialNumber(String assetSerialNumber) {
        this.assetSerialNumber = assetSerialNumber;
    }
}
