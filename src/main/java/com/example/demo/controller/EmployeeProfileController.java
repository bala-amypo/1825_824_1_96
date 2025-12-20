package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    @Autowired
    private EmployeeProfileService service;

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile emp) {
        return service.create(emp);
    }

    @PutMapping("/{id}")
    public EmployeeProfile update(@PathVariable Long id, @RequestBody EmployeeProfile emp) {
        return service.update(id, emp);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }

    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/team/{team}")
    public List<EmployeeProfile> getByTeam(@PathVariable String team) {
        return service.getByTeam(team);
    }

    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAll();
    }
}
