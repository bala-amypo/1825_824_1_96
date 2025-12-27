package com.example.demo.service.impl;
import com.example.demo.model.CapacityAlert;
import com.example.demo.repository.CapacityAlertRepository;
import com.example.demo.service.CapacityAlertService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CapacityAlertServiceImpl implements CapacityAlertService{

    private final CapacityAlertRepository capacityAlertRepository;

    public CapacityAlertServiceImpl(CapacityAlertRepository capacityAlertRepository){
        this.capacityAlertRepository=capacityAlertRepository;
    }
    @Override
    public CapacityAlert createAlert(capacityAlert alert){
        return capacityAlertRepository.save(alert);
    }
    @Override
    public List<CapacityAlert> getAllAlerts(){
        return capacityAlertRepository.findAll();
    }
}