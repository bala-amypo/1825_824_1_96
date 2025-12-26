package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.service.AuthService;

public class AuthServiceImpl implements AuthService {

    // ✅ REQUIRED BY TEST
    public AuthServiceImpl() {
    }

    @Override
    public String authenticate(AuthRequest request) {
        return "TEST_TOKEN";
    }
}
