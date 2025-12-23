package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService{
    @Autowired
    private UserAccountRepository repo;
    @Override
    public UserAccount save(UserAccount user){
        return repo.save(user);
    }
    @Override
    public List<UserAccount> getAll(){
        return repo.findAll
    }
}