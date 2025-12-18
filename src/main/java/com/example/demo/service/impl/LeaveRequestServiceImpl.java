package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.LeaveRequestService;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.EmployeeProfile;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService{
    @Autowired
    private LeaveRequestRepository repo;
    @Autowired
    private EmployeeProfileRepository empRepo;
    @Override
    public LeaveRequest create(LeaveRequest req){
        return repo.save(req);
    }
    @Override
    public void approve(Long id){
        LeaveRequest l=repo.findById(id).orElse(null);
        if(l!=null){
            l.setStatus("APPROVED");
            repo.save(l);
        }
    }
    @Override
    public void reject(Long id){
        LeaveRequest l=repo.findById(id).orElse(null);
        if(l!=null){
            l.setStatus("REJECTED");
            repo.save(l);
        }
    }
    @Override
    public List<LeaveRequest> getByEmployee(Long employeeId){
        EmployeeProfile emp=empRepo.findById(employeeId).orElse(null);
        return repo.findByEmployee(emp);
    }
    @Override
    public List<LeaveRequest> getOverlappingForTeam(String teamName, LocalDate start, LocalDate end){
        return repo.findApprovedOverlappingForTeam(teamName, start, end);
    }
}