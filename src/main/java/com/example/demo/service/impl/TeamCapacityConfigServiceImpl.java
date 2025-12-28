package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.stereotype.Service;

@Service
public class TeamCapacityConfigServiceImpl implements TeamCapacityConfigService {

    private final TeamCapacityConfigRepository repository;

    public TeamCapacityConfigServiceImpl(TeamCapacityConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamCapacityConfig createRule(TeamCapacityConfig rule) {
        return repository.save(rule);
    }

    @Override
    public TeamCapacityConfig updateRule(Long id, TeamCapacityConfig rule) {
        rule.setId(id);
        return repository.save(rule);
    }

    @Override
    public TeamCapacityConfig getRuleByTeam(String teamName) {
        return repository.findByTeamName(teamName).orElse(null);
    }
}
