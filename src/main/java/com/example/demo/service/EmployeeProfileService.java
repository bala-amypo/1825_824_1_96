package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile create(EmployeeProfile profile);

    EmployeeProfile update(Long id, EmployeeProfile profile);

    void deactivate(Long id);

    EmployeeProfile getById(Long id);

    List<EmployeeProfile> getByTeam(String teamName);
}
