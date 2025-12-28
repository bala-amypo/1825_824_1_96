package com.example.demo.service.impl;

import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final UserAccountRepository repository;

    public AuthServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }
}
