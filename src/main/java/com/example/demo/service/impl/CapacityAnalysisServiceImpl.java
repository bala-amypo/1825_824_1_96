package com.example.demo.service.impl;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.CapacityAnalysisService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CapacityAnalysisServiceImpl implements CapacityAnalysisService {

    @Override
    public boolean isCapacityExceeded(
            TeamCapacityConfig config,
            List<LeaveRequest> approvedLeaves,
            int teamSize
    ) {
        if (config == null || teamSize == 0) {
            return false;
        }

        int maxAllowedLeaves =
                (config.getMinCapacityPercent() * teamSize) / 100;

        return approvedLeaves.size() > maxAllowedLeaves;
    }

    @Override
    public int calculateOverlapCount(
            List<LeaveRequest> approvedLeaves,
            LocalDate start,
            LocalDate end
    ) {
        return (int) approvedLeaves.stream()
                .filter(l ->
                        !l.getEndDate().isBefore(start)
                                && !l.getStartDate().isAfter(end))
                .count();
    }
}
