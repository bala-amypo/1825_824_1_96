package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import java.util.List;

@RestController
public class EmployeeProfileController{
    @Autowired
    EmployeeProfileService service;
    @PostMapping("/employee")
    public EmployeeProfile add(@RequestBody EmployeeProfile emp){
        return service.create(emp);
    }
    @PutMapping("/employee/{id}")
    public EmployeeProfile update(@PathVariable Long id, @RequestBody EmployeeProfile emp){
        return service.update(id,emp);
    }
    @PutMapping("/employee/{id}/deactivate")
    public void deactivate(@PathVariable Long id){
        service.deactivate(id);
    }
    @GetMapping("/employee/{id}")
    public EmployeeProfile getById(@PathVariable Long id){
        return service.getById(id);
    }
    @GetMapping("/employee/team/{team}")
    public List<EmployeeProfile> getTeam(@PathVariable String team){
        return service.getByTeam(team);
    }
    @GetMapping("/employees")
    public List<EmployeeProfile> getAll(){
        return service.getAll();
    }
}