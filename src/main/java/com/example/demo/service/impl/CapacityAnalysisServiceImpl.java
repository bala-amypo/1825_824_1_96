package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.model.LeaveRequest;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.CapacityAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class CapacityAnalysisServiceImpl implements CapacityAnalysisService{
    @Autowired
    TeamCapacityConfigRepository configRepo;
    @Autowired
    LeaveRequestRepository leaveRepo;
    @Override
    public Map<LocalDate, Double> analyze(String teamName, LocalDate start, LocalDate end){
        TeamCapacityConfig config=configRepo.findByTeamName(teamName).orElse(null);
        List<LeaveRequest> leaves=leaveRepo.findApprovedOverlappingForTeam(teamName, start, end);
        int total=config.getTotalHeadcount();
        Map<LocalDate, Double> result = new HashMap<>();
        for(LocalDate d = start;!d.isAfter(end); d=d.plusDays(1)){
            long countOnLeave=leaves.stream().filter(l->!d.isBefore(l.getStartDate()) && !d.isAfter(l.getEndDate())).count();
            result.put(d, ((total-countOnLeave)/(double) total)*100);
        }
        return result;
    }
}