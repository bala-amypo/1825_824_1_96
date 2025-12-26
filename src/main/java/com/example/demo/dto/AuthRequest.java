package com.example.demo.dto;

public class AuthRequest{
    private String email;
    private String password;

    public AuthRequest() {}

    public String getEmail(){
        return username;
    }
    public void setUsername(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
}