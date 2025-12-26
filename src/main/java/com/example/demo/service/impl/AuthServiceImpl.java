package com.example.demo.service.impl;
import com.example.demo.dto.*;
import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.*;
import com.example.demo.util.DateRangeUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

// AuthServiceImpl
public class AuthServiceImpl implements AuthService {
    private final UserAccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    public AuthServiceImpl(UserAccountRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }
    @Override
    public AuthResponse authenticate(AuthRequest request) {
        UserAccount user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }
        String token = tokenProvider.generateToken(user);
        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUserId(user.getId());
        return response;
    }
}