package com.example.demo.service;

import java.time.LocaDate;
import java.util.Map;

public interface CapacityAnalysisService{
    Map<LocalDate, Double> analyze(String teamName, LocalDate start, LocalDate end);
}