package com.example.wypozyczalnia.assignment;

import com.example.wypozyczalnia.assets.Asset;
import com.example.wypozyczalnia.user.User;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startBorrow;

    private LocalDateTime endBorrow;
    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Assignment() {
    }

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

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
