package com.example.demo.service.impl;

import com.example.demo.repository.UserAccountRepository;
import com.example.demo.model.UserAccount;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    UserAccountRepository repo;
}