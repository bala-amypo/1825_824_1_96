package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.CapacityAnalysisService;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.stereotype.Service;

@Service
public class CapacityAnalysisServiceImpl
        implements CapacityAnalysisService {

    private final TeamCapacityConfigService configService;

    public CapacityAnalysisServiceImpl(
            TeamCapacityConfigService configService) {
        this.configService = configService;
    }

    @Override
    public boolean isCapacityAvailable(String teamName, int leaveCount) {

        TeamCapacityConfig config = configService.getRuleByTeam(teamName);
        if (config == null) {
            return true;
        }

        double maxAllowedLeaves =
                (config.getMaxLeavePercent() / 100.0)
                        * config.getTotalHeadcount();

        return leaveCount <= maxAllowedLeaves;
    }
}
