package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile profile) {
        return service.create(profile);
    }

    @PutMapping("/{id}")
    public EmployeeProfile update(
            @PathVariable Long id,
            @RequestBody EmployeeProfile profile
    ) {
        return service.update(id, profile);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }

    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/team/{teamName}")
    public List<EmployeeProfile> getByTeam(@PathVariable String teamName) {
        return service.getByTeam(teamName);
    }
}
