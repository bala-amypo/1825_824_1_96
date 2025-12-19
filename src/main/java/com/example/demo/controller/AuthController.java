package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.service.AuthService;

@RestController
public class AuthController{
    @Autowired
    AuthService service;
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req){
        return service.authenticate(req);
    }
}