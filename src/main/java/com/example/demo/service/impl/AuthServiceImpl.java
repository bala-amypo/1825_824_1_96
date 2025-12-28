package com.example.demo.service.impl;

import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final UserAccountRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    // ✅ MATCHES TEST EXPECTATION
    public AuthServiceImpl(UserAccountRepository userRepo,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
}
