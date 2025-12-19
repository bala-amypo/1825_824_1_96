package com.example.demo.service.impl;

import com.example.demo.repository.UserAccountRepository;
import com.example.demo.model.UserAccount;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    UserAccountRepository repo;
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    JwtTokenProvider jwt;
    @Override
    public class authenticate(String username, String password)
}