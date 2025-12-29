package com.example.demo.service;

import com.example.demo.model.TeamCapacityConfig;
import java.util.List;

public interface TeamCapacityConfigService {

    TeamCapacityConfig create(TeamCapacityConfig config);

    TeamCapacityConfig update(Long id, TeamCapacityConfig config);

    TeamCapacityConfig getByTeamName(String teamName);

    List<TeamCapacityConfig> getAll();
}
