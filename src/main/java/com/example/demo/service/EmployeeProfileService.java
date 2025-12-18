package com.example.demo.service;

import com.examole.demo.dto.EmployeeProfileDto;
import java.util.List;

public interface EmployeeProfileService{
    EmployeeProfileDto create(EmployeeProfileDto dto);
    EmployeeProfileDto update(Long id, EmployeeProfileDto dto);
    void deactivate(Long id);
    EmployeeProfileDto getById()
}