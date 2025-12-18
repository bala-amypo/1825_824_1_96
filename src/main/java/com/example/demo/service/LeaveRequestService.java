package com.example.demo.service;

import com.example.demo.dto.LeaveRequestDto;
import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestService{
    LeaveRequestDto create(LeaveRequestDto dto);
    void approve(Long id);
    void reject(Long id);
    List<LeaveRequestDto> getByEmployee(Long employeeId);
    List<LeaveRequestDto> getOverlappingForTeam(String teamName, LocalDate start, LocalDate end);
}