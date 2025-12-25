package com.example.demo.service.impl;

import com.example.demo.model.CapacityAlert;
import com.example.demo.repository.CapacityAlertRepository;
import com.example.demo.service.CapacityAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapacityAlertServiceImpl implements CapacityAlertService {

    private final CapacityAlertRepository repository;

    // ✅ REQUIRED by tests
    public CapacityAlertServiceImpl(CapacityAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CapacityAlert> getByTeam(String teamName) {
        return repository.findByTeamName(teamName);
    }

    @Override
    public CapacityAlert save(CapacityAlert alert) {
        return repository.save(alert);
    }
}
