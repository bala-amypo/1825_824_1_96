package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.demo.model.CapacityAlert;
import com.example.demo.repository.CapacityAlertRepository;
import com.example.demo.service.CapacityAlertService;

@Service
public class CapacityAlertServiceImpl implements CapacityAlertService{
    @Autowired
    private CapacityAlertRepository repo;
    @Override
    public CapacityAlert save(CapacityAlert alert){
        return repo.save(alert);
    }
    @Override
    public List<CapacityAlert> getByTeam(String )
}