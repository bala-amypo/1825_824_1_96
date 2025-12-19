package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;

@RestController
public class CapacityAlertController{
    @Autowired
    CapacityAnalysisService service;
    @PostMapping("/capacity/analyze")
    public CapacityAnalysisResultDto analyze(@RequestParam String teamName, @RequestParam LocalDate start, @RequestParam LocalDate end){
        return service.analyzeTeamCapacity(teamName, start, end);
    }
}