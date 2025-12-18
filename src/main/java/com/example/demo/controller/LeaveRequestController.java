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
}