package com.example.demo.controller;

import com.example.demo.model.LeaveRequest;
import com.example.demo.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService service;

    @PostMapping
    public LeaveRequest apply(@RequestBody LeaveRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}/approve")
    public void approve(@PathVariable Long id) {
        service.approve(id);
    }

    @PutMapping("/{id}/reject")
    public void reject(@PathVariable Long id) {
        service.reject(id);
    }

    @GetMapping("/employee/{id}")
    public List<LeaveRequest> getByEmployee(@PathVariable Long id) {
        return service.getByEmployee(id);
    }

    @GetMapping("/overlap")
    public List<LeaveRequest> overlap(
            @RequestParam String teamName,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return service.getOverlappingForTeam(teamName, start, end);
    }
}
