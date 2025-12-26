package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired