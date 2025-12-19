package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.service.CapacityAnalysisService;
import java.time.LocalDate;
import java.util.Map;

@RestController
public class CapacityAlertController{
    @Autowired
    CapacityAnalysisService service;
    @PostMapping("/capacity/analyze")
    public CapacityAnalysisResultDto analyze(@RequestParam String teamName, @RequestParam LocalDate start, @RequestParam LocalDate end){
        return service.analyzeTeamCapacity(teamName, start, end);
    }
}