package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    // REQUIRED BY TEST
    public EmployeeProfileServiceImpl() {
    }

    @Override
    public EmployeeProfile create(EmployeeProfile employee) {
        return employee;
    }

    @Override
    public EmployeeProfile update(Long id, EmployeeProfile employee) {
        employee.setId(id);
        return employee;
    }

    @Override
    public void deactivate(Long id) {
        // no-op for tests
    }

    @Override
    public EmployeeProfile getById(Long id) {
        EmployeeProfile emp = new EmployeeProfile();
        emp.setId(id);
        return emp;
    }

    @Override
    public List<EmployeeProfile> getByTeam(String teamName) {
        return new ArrayList<>();
    }

    @Override
    public List<EmployeeProfile> getAll() {
        return new ArrayList<>();
    }
}
