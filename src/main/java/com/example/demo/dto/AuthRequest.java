package com.example.demo.dto;

public class AuthRequest {
    private String email;
    private String username;
    private String password;

    public AuthRequest() {
    }

    // === REQUIRED BY TESTS ===
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.username = email;
    }

    public String getEmail() {
        return this.username;
    }

    // === USED BY SERVICE ===
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}