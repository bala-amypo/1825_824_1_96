package com.example.demo.service;

import com.example.demo.dto.AuthRequest;

public interface AuthService {

    String authenticate(AuthRequest request);
}
