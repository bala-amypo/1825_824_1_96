package com.example.demo.service;

import com.example.demo.model.TeamCapacityConfig;

public interface TeamCapacityConfigService{
    TeamCapacityConfig createRule(TeamCapacityConfig rule);
    TeamCapacityConfig updateRule(Long id, TeamCapacityConfig rule);
    TeamCapacityConfig getRuleByTeam(String teamName);
}