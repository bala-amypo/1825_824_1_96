package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.service.CapacityAnalysisService;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CapacityAnalysisServiceImpl
        implements CapacityAnalysisService {

    private TeamCapacityConfigService configService;
    private LeaveRequestRepository leaveRepo;

    // REQUIRED BY TESTS
    public CapacityAnalysisServiceImpl() {
    }

    // OPTIONAL FOR SPRING
    public CapacityAnalysisServiceImpl(
            TeamCapacityConfigService configService,
            LeaveRequestRepository leaveRepo) {
        this.configService = configService;
        this.leaveRepo = leaveRepo;
    }

    @Override
    public boolean analyzeTeamCapacity(
            String teamName,
            LocalDate startDate,
            LocalDate endDate) {

        TeamCapacityConfig config =
                configService.getRuleByTeam(teamName);

        if (config == null) return true;

        int total = config.getTotalHeadcount();
        int minPercent = config.getMinCapacityPercent();

        int maxAllowedLeaves =
                total - (total * minPercent / 100);

        int approvedLeaves =
                leaveRepo.findApprovedOverlappingForTeam(
                        teamName, startDate, endDate).size();

        return approvedLeaves <= maxAllowedLeaves;
    }
}
