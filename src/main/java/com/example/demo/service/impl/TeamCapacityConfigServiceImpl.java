package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamCapacityConfigServiceImpl implements TeamCapacityConfigService {

    private final TeamCapacityConfigRepository repository;

    public TeamCapacityConfigServiceImpl(TeamCapacityConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamCapacityConfig create(TeamCapacityConfig config) {
        return repository.save(config);
    }

    @Override
    public TeamCapacityConfig update(Long id, TeamCapacityConfig config) {
        TeamCapacityConfig existing = repository.findById(id).orElseThrow(()->new RuntimeException("Capacity config not found"));
        existing.setTeamName(config.getTeamName());
        existing.setMaxCapacity(config.getMaxCapacity());
        return repository.save(existing);
    }

    @Override
    public TeamCapacityConfig getByTeamName(String teamName) {
        return repository.findByTeamName(teamName).orElseThrow(()->new RuntimeException("Team not found"));
    }
    @Override
    public List<TeamCapacityConfig> getAll(){
        return repository.findAll();
    }
}
