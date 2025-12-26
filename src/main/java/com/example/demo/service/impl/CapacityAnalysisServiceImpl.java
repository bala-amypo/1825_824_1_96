package com.example.demo.service.impl;
import com.example.demo.dto.CapacityAnalysisResultDto;
import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CapacityAnalysisService;
import com.example.demo.util.DateRangeUtil;
import java.time.LocalDate;
import java.util.*;

public class CapacityAnalysisServiceImpl implements CapacityAnalysisService {
    private final TeamCapacityConfigRepository capacityRepo;
    private final EmployeeProfileRepository employeeRepo;
    private final LeaveRequestRepository leaveRepo;
    private final CapacityAlertRepository alertRepo;
    public CapacityAnalysisServiceImpl(TeamCapacityConfigRepository capacityRepo, 
                                     EmployeeProfileRepository employeeRepo,
                                     LeaveRequestRepository leaveRepo,
                                     CapacityAlertRepository alertRepo) {
        this.capacityRepo = capacityRepo;
        this.employeeRepo = employeeRepo;
        this.leaveRepo = leaveRepo;
        this.alertRepo = alertRepo;
    }
    @Override
    public CapacityAnalysisResultDto analyzeTeamCapacity(String teamName, LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new BadRequestException("Start date must be before or equal to end date");
        }
        TeamCapacityConfig config = capacityRepo.findByTeamName(teamName)
                .orElseThrow(() -> new ResourceNotFoundException("Capacity config not found for team: " + teamName));
        if (config.getTotalHeadcount() <= 0) {
            throw new BadRequestException("Invalid total headcount for team: " + teamName);
        }
        List<LeaveRequest> overlappingLeaves = leaveRepo.findApprovedOverlappingForTeam(teamName, startDate, endDate);
        Map<LocalDate, Integer> capacityByDate = new HashMap<>();
        List<LocalDate> dateRange = DateRangeUtil.daysBetween(startDate, endDate);
        boolean isRisky = false;
        for (LocalDate date : dateRange) {
            int leavesOnDate = overlappingLeaves.size();
            int availableCapacity = ((config.getTotalHeadcount() - leavesOnDate) * 100) / config.getTotalHeadcount();
            capacityByDate.put(date, availableCapacity);
            if (availableCapacity < config.getMinCapacityPercent()) {
                isRisky = true;
                CapacityAlert alert = new CapacityAlert(teamName, date, "HIGH", "Capacity below threshold");
                alertRepo.save(alert);
            }
        }
        CapacityAnalysisResultDto result = new CapacityAnalysisResultDto();
        result.setRisky(isRisky);
        result.setCapacityByDate(capacityByDate);
        return result;
    }
}