package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Map;

@Data
public class CapacityAnalysisDetailsDto{
    private boolean risky;
    private Map<LocalDate, Double> capacityByDate;
}