package com.example.demo.controller;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class TeamCapacityConfigController {

    @Autowired
    private TeamCapacityConfigService service;

    @PostMapping
    public TeamCapacityConfig create(@RequestBody TeamCapacityConfig rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TeamCapacityConfig update(
            @PathVariable Long id,
            @RequestBody TeamCapacityConfig rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/team/{team}")
    public TeamCapacityConfig getByTeam(@PathVariable String team) {
        return service.getRuleByTeam(team);
    }
}
