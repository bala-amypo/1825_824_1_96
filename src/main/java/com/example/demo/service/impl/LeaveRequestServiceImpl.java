package com.example.demo.service.impl;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository repo;
    private final EmployeeProfileRepository empRepo;

    public LeaveRequestServiceImpl(LeaveRequestRepository repo,
                                   EmployeeProfileRepository empRepo) {
        this.repo = repo;
        this.empRepo = empRepo;
    }

    @Override
    public LeaveRequest create(LeaveRequest leave) {
        return repo.save(leave);
    }

    @Override
    public void approve(Long id) {
        LeaveRequest req = repo.findById(id).orElse(null);
        if (req != null) {
            req.setStatus("APPROVED");
            repo.save(req);
        }
    }

    @Override
    public void reject(Long id) {
        LeaveRequest req = repo.findById(id).orElse(null);
        if (req != null) {
            req.setStatus("REJECTED");
            repo.save(req);
        }
    }

    @Override
    public List<LeaveRequest> getByEmployee(Long employeeId) {
        EmployeeProfile emp = empRepo.findById(employeeId).orElse(null);
        if (emp == null) {
            return List.of();   // SAFE: avoid null
        }
        return repo.findByEmployee(emp);
    }

    @Override
    public List<LeaveRequest> getOverlappingForTeam(String teamName,
                                                    LocalDate start,
                                                    LocalDate end) {
        // TEMPORARY SAFE IMPLEMENTATION (Swagger only)
        return repo.findAll();
    }
}
