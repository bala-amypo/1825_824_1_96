package com.example.demo.service;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.model.LeaveRequest;

import java.time.LocalDate;
import java.util.List;

public interface CapacityAnalysisService {

    boolean isCapacityExceeded(
            TeamCapacityConfig config,
            List<LeaveRequest> approvedLeaves,
            int teamSize
    );

    int calculateOverlapCount(
            List<LeaveRequest> approvedLeaves,
            LocalDate start,
            LocalDate end
    );
}
