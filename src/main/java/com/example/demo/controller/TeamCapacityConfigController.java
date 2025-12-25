package com.example.demo.controller;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capacity-config")
public class TeamCapacityConfigController {

    private final TeamCapacityConfigService service;

    public TeamCapacityConfigController(
            TeamCapacityConfigService service) {
        this.service = service;
    }

    @PostMapping
    public TeamCapacityConfig create(
            @RequestBody TeamCapacityConfig config
    ) {
        return service.createRule(config);
    }

    @PutMapping("/{id}")
    public TeamCapacityConfig update(
            @PathVariable Long id,
            @RequestBody TeamCapacityConfig config
    ) {
        return service.updateRule(id, config);
    }

    @GetMapping("/team/{teamName}")
    public TeamCapacityConfig getByTeam(
            @PathVariable String teamName
    ) {
        return service.getRuleByTeam(teamName);
    }
}
