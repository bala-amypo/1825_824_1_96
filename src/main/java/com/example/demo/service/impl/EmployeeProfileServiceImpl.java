package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeProfile create(EmployeeProfile emp) {
        return repo.save(emp);
    }

    @Override
    public EmployeeProfile update(Long id, EmployeeProfile emp) {
        emp.setId(id);
        return repo.save(emp);
    }

    @Override
    public void deactivate(Long id) {
        EmployeeProfile emp = repo.findById(id).orElse(null);
        if (emp != null) {
            emp.setActive(false);
            repo.save(emp);
        }
    }

    @Override
    public EmployeeProfile getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeProfile> getByTeam(String team) {
        return repo.findByTeamNameAndActiveTrue(team);
    }

    @Override
    public List<EmployeeProfile> getAll() {
        return repo.findAll();
    }
}
