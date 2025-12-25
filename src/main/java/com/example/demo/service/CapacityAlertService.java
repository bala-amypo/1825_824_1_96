package com.example.demo.service;

import com.example.demo.model.CapacityAlert;
import java.util.List;

public interface CapacityAlertService {

    CapacityAlert save(CapacityAlert alert);

    List<CapacityAlert> getByTeam(String teamName);
}
