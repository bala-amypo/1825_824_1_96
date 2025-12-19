package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityConfigService;

@RestController
public class TeamCapacityConfigController{
    @Autowired
    TeamCapacityConfigService service;
    @PostMapping("/rule")
    public TeamCapacityConfig add(@RequestBody TeamCapacityConfig rule){
        return service.createRule(rule);
    }
    @PutMapping("/rule/{id}")
    public TeamCapacityConfig update(@PathVariable Long id, @RequestBody TeamCapacityConfig rule){
        return service.updateRule(id, rule);
    }
    @GetMapping("/rule/team/{team}")
    public TeamCapacityConfig getRule(@PathVariable String team){
        return service.getRuleByTeam(team);
    }
}