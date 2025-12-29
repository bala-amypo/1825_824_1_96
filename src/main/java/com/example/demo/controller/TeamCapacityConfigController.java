package com.example.demo.controller;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/capacity-config")
public class TeamCapacityConfigController{

    private final TeamCapacityConfigService service;

    public TeamCapacityConfigController(TeamCapacityConfigService service){
        this.service=service;
    }
    @PostMapping
    public ResponseEntity<TeamCapacityConfig> create(@RequestBody TeamCapacityConfig config){
        if(config.getTotalHeadcount()<=0){
           throw new IllegalArguementException("totalHeadcount must be > 0");
        }
        if(config)
        return ResponseEntity.ok(service.create(config));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeamCapacityConfig> update(@PathVariable Long id, @RequestBody TeamCapacityConfig config){
        return ResponseEntity.ok(service.update(id, config));
    }
    @GetMapping("/{teamName}")
    public ResponseEntity<TeamCapacityConfig> getByTeam(@PathVariable String teamName){
        return ResponseEntity.ok(service.getByTeamName(teamName));
    }
    @GetMapping
    public ResponseEntity<List<TeamCapacityConfig>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}



