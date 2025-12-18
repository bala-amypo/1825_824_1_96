package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import java.util.List;

@RestController
public class EmployeeProfileController{
    @Autowired
    EmployeeProfileService service;
    @PostMapping("/employee")
    public EmployeeProfile add(@RequestBody EmployeeProfile emp){
        return service.create(emp);
    }
    @PutMapping("/employee/{id}")
    public Employee
}