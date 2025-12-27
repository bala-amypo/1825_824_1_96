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
public class AuthServiceImpl implements AuthService{
    private final UserAccountRepository userAccountRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(
        UserAccountRepository userAccountRepository,
        BCryptPasswordEncoder passwordEncoder,
        JwtTokenProvider jwtTokenProvider
)   {
    this.userAccountRepository=userAccountRepository;
    this.passwordEncoder=passwordEncoder;
    this.jwtTokenProvider=jwtTokenProvider;
}

@Override
public AuthResponse authenicate(AuthRequest request){
    UserAccount user=userAccountRepository.findByEmail(request.getEmail()).orElse(()->new RuntimeException("User not found"));
    if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
        throw new RuntimeException("Invalid password");
    }
    String token=jwtTokenProvider.generateToken(user);
    return new AuthResponse(user.getId(),token);
}
}