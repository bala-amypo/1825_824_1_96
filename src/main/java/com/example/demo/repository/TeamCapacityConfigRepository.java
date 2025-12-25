package com.example.demo.repository;

import com.example.demo.model.TeamCapacityConfig;

public interface TeamCapacityConfigRepository {

    // ❌ NO Optional
    TeamCapacityConfig findByTeamName(String teamName);
}
