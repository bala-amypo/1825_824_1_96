package com.example.demo.controller;
import com.example.demo.dto.EmployeeProfileDto;
import com.example.demo.service.EmployeeProfileService;
import java.util.List;

public class EmployeeProfileController {
    private final EmployeeProfileService service;
    
    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }
    
    public EmployeeProfileDto create(EmployeeProfileDto dto) {
        return service.create(dto);
    }
    
    public EmployeeProfileDto getById(Long id) {
        return service.getById(id);
    }
    
    public EmployeeProfileDto update(Long id, EmployeeProfileDto dto) {
        dto.setId(id);
        return service.update(dto);
    }
    
    public List<EmployeeProfileDto> addColleagues(Long id, List<Long> colleagueIds) {
        return service.addColleagues(id, colleagueIds);
    }
}