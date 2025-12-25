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
    public TeamCapacityConfig createRule(TeamCapacityConfig rule) {
        return repo.save(rule);
    }

    @Override
    public TeamCapacityConfig updateRule(Long id, TeamCapacityConfig rule) {

        TeamCapacityConfig existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setTeamName(rule.getTeamName());
        existing.setTotalHeadcount(rule.getTotalHeadcount());
        existing.setMaxLeavePercent(rule.getMaxLeavePercent());

        return repo.save(existing);
    }

    @Override
    public TeamCapacityConfig getRuleByTeam(String team) {
        return repo.findByTeamName(team).orElse(null);
    }
}
