package com.example.demo.controller;

import com.example.demo.model.CapacityAlert;
import com.example.demo.service.CapacityAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capacity-alerts")
public class CapacityAlertController {

    private final CapacityAlertService capacityAlertService;

    public CapacityAlertController(CapacityAlertService capacityAlertService) {
        this.capacityAlertService = capacityAlertService;
    }

    @GetMapping
    public List<CapacityAlert> getAllAlerts(){
        return capacityAlertService.getAllAlerts();
    }
}
