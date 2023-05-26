package com.example.wypozyczalnia.assignment;

import com.example.wypozyczalnia.user.User;

import java.time.LocalDateTime;

public class AssignmentUserDto {

    private Long id;
    private LocalDateTime startBorrow;
    private LocalDateTime endBorrow;
    private Long userId;
    private String userName;
    private String userLastName;
    private String userPesel;


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPesel() {
        return userPesel;
    }

    public void setUserPesel(String userPesel) {
        this.userPesel = userPesel;
    }
}
