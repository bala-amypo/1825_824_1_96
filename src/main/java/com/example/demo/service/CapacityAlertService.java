package com.example.demo.service;

import com.example.demo.model.CapacityAlert;

import java.util.List;

public interface CapacityAlertService {

    List<CapacityAlert> getByTeam(String teamName);

    CapacityAlert save(CapacityAlert alert);
}
