package com.example.demo.controller;

import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    // ✅ Constructor injection (BEST PRACTICE)
    @Autowired
    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    // ✅ Dummy endpoint just to keep Swagger & app running
    @GetMapping("/health")
    public String healthCheck() {
        return "UserAccountController is working";
    }
}
