package com.example.demo.repository;

import com.example.demo.model.CapacityAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CapacityAlertRepository
        extends JpaRepository<CapacityAlert, Long> {

    // Used by test cases
    List<CapacityAlert> findByTeamNameAndDateBetween(
            String teamName,
            LocalDate startDate,
            LocalDate endDate
    );

    // 🔥 MUST RETURN LIST (NOT Optional)
    List<CapacityAlert> findByTeamName(String teamName);
}
