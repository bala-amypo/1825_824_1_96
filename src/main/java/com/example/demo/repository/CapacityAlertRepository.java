package com.example.demo.repository;

import com.example.demo.model.CapacityAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CapacityAlertRepository extends JpaRepository<CapacityAlert, Long> {

    // Used in test cases
    List<CapacityAlert> findByTeamNameAndDateBetween(
            String teamName,
            LocalDate startDate,
            LocalDate endDate
    );

    // Used in service implementation AND tests
    List<CapacityAlert> findByTeamName(String teamName);
}
