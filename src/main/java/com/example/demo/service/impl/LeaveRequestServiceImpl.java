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
}