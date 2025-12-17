package com.example.demo.dto;

import java.util.Map;
import java.time.LocalDate;

public class CapacityAnalysisDetailsDto{
    private boolean risky;
    private Map<LocalDate, Double> capacityByDate;
}