package com.example.demo.service;

import java.time.LocalDate;

public interface CapacityAnalysisService {

    boolean analyzeTeamCapacity(
            String teamName,
            LocalDate start,
            LocalDate end
    );
}
