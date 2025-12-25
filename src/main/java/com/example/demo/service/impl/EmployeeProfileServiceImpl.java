package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeProfileDto;
import com.example.demo.service.EmployeeProfileService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProfileServiceImpl
        implements EmployeeProfileService {

    public EmployeeProfileServiceImpl() {}

    @Override
    public EmployeeProfileDto create(EmployeeProfileDto dto) {
        return dto;
    }

    @Override
    public List<EmployeeProfileDto> getAll() {
        return new ArrayList<>();
    }
}
