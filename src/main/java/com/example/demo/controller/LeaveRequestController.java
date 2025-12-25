package com.example.demo.controller;

import com.example.demo.model.LeaveRequest;
import com.example.demo.service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    private final LeaveRequestService service;

    public LeaveRequestController(LeaveRequestService service) {
        this.service = service;
    }

    @PostMapping
    public LeaveRequest create(@RequestBody LeaveRequest request) {
        return service.create(request);
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getByEmployee(
            @PathVariable Long employeeId
    ) {
        return service.getByEmployee(employeeId);
    }

    @GetMapping("/approved/team/{teamName}")
    public List<LeaveRequest> getApprovedByTeam(
            @PathVariable String teamName
    ) {
        return service.getApprovedByTeam(teamName);
    }
}
