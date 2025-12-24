package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.CapacityAlert;
import com.example.demo.service.CapacityAlertService;
import java.util.List;

@RestController
public class CapacityAlertController{
    @Autowired
    private CapacityAlertService service;
    @PostMapping("/capacity-alerts")
    public CapacityAlert create(@RequestBody CapacityAlert alert){
        return service.save(alert);
    }
    @GetMapping("/capacity-alerts/team/{teamName}")
    public List<CapacityAlert> getByTeam(@PathVariable String teamName){
        return service.getByTeam(teamName);
    }
}