package com.example.demo.service.impl;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;

public class UserAccountServiceImpl {
    private final UserAccountRepository repository;
    
    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }
    
    public UserAccount save(UserAccount account) {
        return repository.save(account);
    }
}