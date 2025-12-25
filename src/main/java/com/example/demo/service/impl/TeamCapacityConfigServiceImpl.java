package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.stereotype.Service;

@Service
public class TeamCapacityConfigServiceImpl
        implements TeamCapacityConfigService {

    private final TeamCapacityConfigRepository repo;

    public TeamCapacityConfigServiceImpl(TeamCapacityConfigRepository repo) {
        this.repo = repo;
    }

    @Override
    public TeamCapacityConfig getRuleByTeam(String teamName) {
        return repo.findByTeamName(teamName).orElse(null);
    }

    @Override
    public TeamCapacityConfig save(TeamCapacityConfig config) {
        return repo.save(config);
    }
}
