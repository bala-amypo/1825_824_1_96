package com.example.demo.service.impl;
import com.example.demo.dto.LeaveRequestDto;
import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.LeaveRequestService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LeaveRequestServiceImpl implements LeaveRequestService {
    private final LeaveRequestRepository leaveRepository;
    private final EmployeeProfileRepository employeeRepository;
    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRepository, EmployeeProfileRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }
    @Override
    public LeaveRequestDto create(LeaveRequestDto dto) {
        if (dto.getStartDate().isAfter(dto.getEndDate())) {
            throw new BadRequestException("Start date must be before end date");
        }
        EmployeeProfile employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        LeaveRequest entity = new LeaveRequest();
        entity.setEmployee(employee);
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setType(dto.getType());
        entity.setReason(dto.getReason());
        entity.setStatus("PENDING");
        LeaveRequest saved = leaveRepository.save(entity);
        return toDto(saved);
    }
    @Override
    public LeaveRequestDto approve(Long id) {
        LeaveRequest entity = leaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found"));
        entity.setStatus("APPROVED");
        LeaveRequest saved = leaveRepository.save(entity);
        return toDto(saved);
    }
    @Override
    public LeaveRequestDto reject(Long id) {
        LeaveRequest entity = leaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found"));
        entity.setStatus("REJECTED");
        LeaveRequest saved = leaveRepository.save(entity);
        return toDto(saved);
    }
    @Override
    public List<LeaveRequestDto> getByEmployee(Long employeeId) {
        EmployeeProfile employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return leaveRepository.findByEmployee(employee).stream().map(this::toDto).collect(Collectors.toList());
    }
    @Override
    public List<LeaveRequestDto> getOverlappingForTeam(String teamName, LocalDate startDate, LocalDate endDate) {
        return leaveRepository.findApprovedOverlappingForTeam(teamName, startDate, endDate)
                .stream().map(this::toDto).collect(Collectors.toList());
    }
    @Override
    public List<LeaveRequestDto> getApprovedByTeam(String teamName) {
        return leaveRepository.findApprovedOverlappingForTeam(teamName, LocalDate.now(), LocalDate.now().plusDays(30))
                .stream().map(this::toDto).collect(Collectors.toList());
    }
    private LeaveRequestDto toDto(LeaveRequest entity) {
        LeaveRequestDto dto = new LeaveRequestDto();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployee().getId());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setReason(entity.getReason());
        return dto;
    }
}