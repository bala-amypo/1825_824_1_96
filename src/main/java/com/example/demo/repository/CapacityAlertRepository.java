package com.example.demo.repository;

import com.example.demo.model.CapacityAlert;
import java.time.LocalDate;
import java.util.List;

public interface CapacityAlertRepository {
    CapacityAlert save(CapacityAlert alert);
    List<CapacityAlert> findByTeamNameAndDateBetween(String teamName, LocalDate startDate, LocalDate endDate);
}