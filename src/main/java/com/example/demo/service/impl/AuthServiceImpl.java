package com.example.demo.service.impl;

import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // Constructor used by Spring
    public AuthServiceImpl(UserAccountRepository userRepo,
                           BCryptPasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // Constructor used by tests
    public AuthServiceImpl(UserAccountRepository userRepo,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = null;
    }

    // ✅ IMPLEMENT ALL METHODS FROM AuthService INTERFACE
    // Example (adjust names to your interface)

    @Override
    public String login(String email, String password) {
        // your existing logic
        return "TOKEN";
    }
}
