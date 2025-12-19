package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService{
    EmployeeProfile create(EmployeeProfile emp);
    EmployeeProfile update(Long id, EmployeeProfile emp);
    void deactivate(Long id);
    EmployeeProfile getbyId(Long id);
    List<EmployeeProfile> getByTeam(String team);
    List<EmployeeProfile> getAll();
}