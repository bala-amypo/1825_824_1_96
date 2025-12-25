package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    // ✅ REQUIRED by tests
    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile create(EmployeeProfile profile) {
        return repository.save(profile);
    }

    @Override
    public EmployeeProfile update(Long id, EmployeeProfile profile) {
        EmployeeProfile existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(profile.getName());
        existing.setTeamName(profile.getTeamName());
        existing.setActive(profile.isActive());

        return repository.save(existing);
    }

    @Override
    public void deactivate(Long id) {
        EmployeeProfile existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setActive(false);
            repository.save(existing);
        }
    }

    @Override
    public EmployeeProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeProfile> getByTeam(String teamName) {
        return repository.findByTeamName(teamName);
    }
}
