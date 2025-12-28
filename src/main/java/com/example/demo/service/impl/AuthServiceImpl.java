package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userAccountRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // ✅ Constructor injection (Spring + Tests friendly)
    public AuthServiceImpl(UserAccountRepository userAccountRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ MUST MATCH AuthService INTERFACE EXACTLY
    @Override
    public AuthResponse authenticate(AuthRequest request) {

        // 1️⃣ Fetch user by email
        UserAccount user = userAccountRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // 2️⃣ Validate password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // 3️⃣ Generate JWT token
        String token = jwtTokenProvider.generateToken(user);

        // 4️⃣ Return AuthResponse (TEST EXPECTS userId)
        return new AuthResponse(
                user.getId(),        // ✅ REQUIRED by test: getUserId()
                token,
                user.getEmail(),
                user.getRole()
        );
    }
}
