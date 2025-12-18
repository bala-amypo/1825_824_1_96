package com.example.demo.service.impl;

import com.example.demo.service.CapacityAnalysisService;
import com.exmaple.demo.dto.CapacityAnalysisResultDto;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.model.LeaveRequest;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CapacityAnalysisServiceImpl implements CapacityAnalysisService{
    @Autowired
    private TeamCapacityConfigRepository configRepo;
    @Autowired
    private LeaveRequestRepository leaveRepo;
    @Autowired
    private EmployeeProfileRepository empRepo;
    @Override
    public CapacityAnalysisResultDto analyzeTeamCapacity(String teamName, LocalDate start, LocalD)
}