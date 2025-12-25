package com.example.demo.service.impl;

import com.example.demo.model.CapacityAlert;
import com.example.demo.repository.CapacityAlertRepository;
import com.example.demo.service.CapacityAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapacityAlertServiceImpl implements CapacityAlertService {

    private final CapacityAlertRepository repo;

    public CapacityAlertServiceImpl(CapacityAlertRepository repo) {
        this.repo = repo;
    }

    /**
     * REQUIRED by CapacityAlertService
     */
    @Override
    public List<CapacityAlert> getByTeam(String teamName) {
        return repo.findByTeamName(teamName)
                .map(List::of)
                .orElse(List.of());
    }

    /**
     * REQUIRED by CapacityAlertService
     */
    @Override
    public CapacityAlert save(CapacityAlert alert) {
        return repo.save(alert);
    }
}
