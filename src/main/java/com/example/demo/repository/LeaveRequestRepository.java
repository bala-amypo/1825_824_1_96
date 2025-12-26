package com.example.demo.repository;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.EmployeeProfile;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LeaveRequestRepository {
    LeaveRequest save(LeaveRequest leaveRequest);
    Optional<LeaveRequest> findById(Long id);
    List<LeaveRequest> findByEmployee(EmployeeProfile employee);
    List<LeaveRequest> findApprovedOverlappingForTeam(String teamName, LocalDate startDate, LocalDate endDate);
    List<LeaveRequest> findApprovedOnDate(LocalDate date);
    void deleteById(Long id);
}