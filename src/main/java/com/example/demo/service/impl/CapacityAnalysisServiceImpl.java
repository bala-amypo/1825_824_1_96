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
    public CapacityAnalysisResultDto analyzeTeamCapacity(String teamName, LocalDate start, LocalDate end){
        TeamCapacityConfig config=configRepo.findByTeamName(teamName).orElse(null);
        List<LeaveRequest> leaves=leaveRepo.findApprovedOverlappingForTeam(teamName, start, end);
        int total=config.getTotalHeadcount();
        boolean risky=false;
        Map<LocalDate, Double> map=new HashMap<>();
        for(LocalDate d=start;id.isAfter(end);d=d.plusDays(1)){
            long onLeave=leaves.stream().filter(l->!d.isBefore(l.getStartDate()) && !d.isAfter(l.getEndDate())).count();
            double capacity=((double)(total-onLeave)/total)*100;
            map.put(d, capacity);
            if(capacity<config.getMinCapacityPercent()) risky=true;
        }
        CapacityAnalysisResultDto dto=new CapacityAnalysisResultDto();
        d
    }
}