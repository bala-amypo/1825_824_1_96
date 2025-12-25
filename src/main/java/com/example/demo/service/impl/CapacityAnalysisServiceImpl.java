package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.model.LeaveRequest;
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

        int minCapacityPercent = config.getMinCapacityPercent();

        int maxAllowedLeaves =
                teamSize - ((teamSize * minCapacityPercent) / 100);

        return approvedLeaves.size() > maxAllowedLeaves;
    }

    @Override
    public int calculateOverlapCount(
            List<LeaveRequest> approvedLeaves,
            LocalDate start,
            LocalDate end
    ) {
        if (approvedLeaves == null || start == null || end == null) {
            return 0;
        }

        int count = 0;
        for (LeaveRequest leave : approvedLeaves) {
            if (!(leave.getEndDate().isBefore(start)
                    || leave.getStartDate().isAfter(end))) {
                count++;
            }
        }
        return count;
    }
}
