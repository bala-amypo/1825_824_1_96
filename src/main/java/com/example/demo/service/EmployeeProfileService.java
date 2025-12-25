package com.example.demo.service;

import com.example.demo.dto.EmployeeProfileDto;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfileDto create(EmployeeProfileDto dto);

    List<EmployeeProfileDto> getAll();
}
