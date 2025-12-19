package com.example.demo.service;

import com.example.demo.model.UserAccount;

public interface AuthService{
    String authenticate(String username, String password);
}