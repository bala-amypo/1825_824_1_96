package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamCapacityConfigServiceImpl implements TeamCapacityConfigService{
    @Autowired
    TeamCapacityConfigRepository repo;
    @Override
    public TeamCapacityConfig createRule(TeamCapacityConfig rule){
        return repo.save(rule);
    }
    @Override
    public TeamCapacityConfig updateRule(Long id, TeamCapacityConfig rule){
        rule.setId(id);
        return repo.save(rule);
    }
    @Override
    public TeamCapacityConfig getRuleByTeam(String teamName){
        return repo.findByTeamName(teamName).orElse(null);
    }
}