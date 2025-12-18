package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.LeaveRequest;
import com.example.demo.service.LeaveRequestService;
import java.time.LocalDate;
import java.util.List;

@RestController
public class LeaveRequestController{
    @Autowired
    LeaveRequestService service;
    @PostMapping("/leave")
    public LeaveRequest add(@RequestBody LeaveRequest req){
        return service.create(req);
    }
    @PutMapping("/leave/{id}/approve")
    public void approve(@PathVariable Long id){
        service.approve(id);
    }
    @PutMapping("/leave/{id}/reject")
    public void reject(@PathVariable Long id){
        service.reject(id);
    }
    @GetMapping("/leave/employee/{id}")
    public List<LeaveRequest> getByEmployee(@PathVariable Long id){
        return service.getByEmployee(id);
    }
    @GetMapping("/leave/overlap")
    public List<LeaveRequest> overlap(@RequestParam String teamName, @RequestParam LocalDate start, @RequestParam LocalDate end){
        return service.getOverlappingForTeam(teamName, start, end);
    }
}