package com.example.demo.service.impl;
import com.example.demo.model.CapacityAlert;
import com.example.demo.repository.CapacityAlertRepository;

public class CapacityAlertServiceImpl {
    private final CapacityAlertRepository repository;
    
    public CapacityAlertServiceImpl(CapacityAlertRepository repository) {
        this.repository = repository;
    }
    
    public CapacityAlert save(CapacityAlert alert) {
        return repository.save(alert);
    }
}