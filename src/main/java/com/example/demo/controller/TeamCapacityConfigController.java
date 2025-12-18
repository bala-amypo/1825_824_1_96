package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityConfigService;

@RestController
public class TeamCapacityConfigController{
    @Autowired
    TeamCapacityConfigService service;
    @PostMapping("/rule")
    public 
}