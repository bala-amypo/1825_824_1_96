package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.sprinhgframework.beans.factory.annotation.Autowired;
import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import java.util.List;

@RestController
public class UserAccountController{
    @Autowired
    private UserAccountService service;
    @PostMapping("/users")
    public UserAccount add(@RequestBody UserAccount user){
        return service.save(user);
    }
    @GetMapping("/users")
    public List<UserAccount> geta
}