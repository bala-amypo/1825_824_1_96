package com.example.demo.repository;
import com.example.demo.model.TeamCapacityConfig;
import java.util.Optional;
public interface TeamCapacityConfigRepository {
    TeamCapacityConfig save(TeamCapacityConfig config);
    Optional<TeamCapacityConfig> findByTeamName(String teamName);
    Optional<TeamCapacityConfig> findById(Long id);
}