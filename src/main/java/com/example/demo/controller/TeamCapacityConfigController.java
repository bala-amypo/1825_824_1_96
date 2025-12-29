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
        if(config.getMinCapacityPercent()<=0 || config.getMinCapacityPercent()>100){
           throw new IllegalArguementException("minCapacityPercent must be between 1 and 100");
        }
        if(config.getMaxCapacity()<=0){
           throw new IllegalArguementException("maxCapacity must be > 0");
        }
        if(config.getMaxCapacity() > config.getTotalHeadcount()){
           throw new IllegalArguementException("maxCapacity cannot be exceed totalHeadcount");
        }
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



