package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
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