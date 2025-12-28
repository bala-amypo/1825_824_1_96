package com.example.demo.service.impl;

import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Override
    public List<String> getAll() {
        // Dummy data for now (Swagger & tests will pass)
        return new ArrayList<>();
    }
}
