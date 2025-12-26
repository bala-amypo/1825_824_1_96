package com.example.demo.controller;
import com.example.demo.dto.LeaveRequestDto;
import com.example.demo.service.LeaveRequestService;
import java.util.List;

public class LeaveRequestController {
    private final LeaveRequestService service;
    
    public LeaveRequestController(LeaveRequestService service) {
        this.service = service;
    }
    
    public LeaveRequestDto create(LeaveRequestDto dto) {
        return service.create(dto);
    }
    
    public List<LeaveRequestDto> getByEmployee(Long employeeId) {
        return service.getByEmployee(employeeId);
    }
    
    public List<LeaveRequestDto> getApprovedByTeam(String teamName) {
        return service.getByEmployee(1L); // Placeholder implementation
    }
}