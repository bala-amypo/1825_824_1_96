package com.example.demo.service.impl;

import com.example.demo.service.AuthService;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.UserAccount;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserAccountRepository repo;
    @Autowired 
    private BCryptPasswordEncoder encoder;
    @Autowired
    private JwtTokenProvider jwt;
    @Override
    public AuthResponse authenticate(AuthRequest req){
        UserAccount user=repo.findByUsername(req.getUsername()).orElse(null);
        if(user!=null && encoder.matches(req.getPassword(), user.getPassword())){
            String token=jwt.generateToken(user.getUsername());
        }
        return null;
    }
}