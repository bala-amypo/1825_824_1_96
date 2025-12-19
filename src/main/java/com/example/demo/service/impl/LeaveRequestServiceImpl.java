package com.example.demo.service.impl;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService{
    @Autowired
    LeaveRequestRepository repo;
    @Autowired
    EmployeeProfileRepository empRepo;
    @Override
    public LeaveRequest create(LeaveRequest leave){
        return repo.save(leave);
    }
    @Override
    public void approve(Long id){
        LeaveRequest req=repo.findById(id).orElse(null);
        if(req!=null){
            req.setStatus("APPROVED");
            repo.save(req);
        }
    }
    @Override
    public void reject(Long id){
        LeaveRequest req=repo.findById(id).orElse(null);
        if(req!=null){
            req.setStatus("REJECTED");
            repo.save(req);
        }
    }
    @Override
    public lis
}