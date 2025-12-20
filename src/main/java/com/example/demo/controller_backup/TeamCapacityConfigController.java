package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityConfigService;

@RestController
@RequestMapping("/rule")
public class TeamCapacityConfigController {

    @Autowired
    private TeamCapacityConfigService service;

    @PostMapping
    public TeamCapacityConfig add(@RequestBody TeamCapacityConfig rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TeamCapacityConfig update(@PathVariable Long id,
                                     @RequestBody TeamCapacityConfig rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/team/{team}")
    public TeamCapacityConfig getRule(@PathVariable String team) {
        return service.getRuleByTeam(team);
    }
}
