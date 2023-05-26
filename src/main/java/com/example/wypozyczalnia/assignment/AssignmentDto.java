package com.example.wypozyczalnia.assignment;

import java.time.LocalDateTime;

public class AssignmentDto {
    private Long id;
    private LocalDateTime startBorrow;
    private LocalDateTime endBorrow;
    private Long userId;
    private Long assetId;


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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }
}
