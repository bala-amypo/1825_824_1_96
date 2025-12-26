package com.example.demo.service.impl;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.CapacityAnalysisService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CapacityAnalysisServiceImpl implements CapacityAnalysisService {

    // ✅ NO constructor args (tests expect this)
    public CapacityAnalysisServiceImpl() {}

    @Override
    public boolean isCapacityExceeded(
            TeamCapacityConfig config,
            List<LeaveRequest> approvedLeaves,
            int teamSize
    ) {
        if (config == null || teamSize == 0) {
            return false;
        }

        int allowedMin =
                (config.getMinCapacityPercent() * teamSize) / 100;

        int available =
                teamSize - approvedLeaves.size();

        return available < allowedMin;
    }

    @Override
    public int calculateOverlapCount(
            List<LeaveRequest> approvedLeaves,
            LocalDate start,
            LocalDate end
    ) {
        int count = 0;

        for (LeaveRequest leave : approvedLeaves) {
            if (!leave.getEndDate().isBefore(start)
                    && !leave.getStartDate().isAfter(end)) {
                count++;
            }
        }
        return count;
    }
}
