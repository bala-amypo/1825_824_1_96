package com.example.demo.service.impl;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.TeamCapacityConfigRepository;

public class TeamCapacityConfigServiceImpl {
    private final TeamCapacityConfigRepository repository;
    
    public TeamCapacityConfigServiceImpl(TeamCapacityConfigRepository repository) {
        this.repository = repository;
    }
    
    public TeamCapacityConfig getByTeam(String teamName) {
        return repository.findByTeamName(teamName).orElse(null);
    }
}