package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityConfigService;
import com.example.demo.repository.TeamCapacityConfigRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TeamCapacityConfigServiceImpl implements TeamCapacityConfigService{
    @Autowired
    private TeamCapacityConfigRepository repo;
    @Override
    public TeamCapacityConfig createRule(TeamCapacityConfig rule){
        return repo.save(rule);
    }
    @Override
    public TeamCapacityConfig updateRule(LOng id, TeamCapacityConfig rule){
        rule.setId(id);
        return repo.save(rule);
    }
    @Override
    public TeamCapacityConfig getRuleByTeam(String teamName){
        return repo.findByTeamName(teamName).orElse(null);
    }
}