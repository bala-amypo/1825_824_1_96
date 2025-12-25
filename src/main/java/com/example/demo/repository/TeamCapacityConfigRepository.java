package com.example.demo.repository;

import com.example.demo.model.TeamCapacityConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamCapacityConfigRepository
        extends JpaRepository<TeamCapacityConfig, Long> {

    // ✅ REQUIRED BY TEST
    Optional<TeamCapacityConfig> findByTeamName(String teamName);
}
