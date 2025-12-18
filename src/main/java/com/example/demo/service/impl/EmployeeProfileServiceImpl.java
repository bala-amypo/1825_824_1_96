package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService{

    @Autowired
    private EmployeeProfileRepository repo;

    @Override
    public EmployeeProfile create(EmployeeProfile employee){
        return repo.save(employee);
    } 
    @Override
    public EmployeeProfile update(Long id, EmployeeProfile employee){
        employee.setId(id);
        return repo.save(employee);
    }
    @Override
    public void deactivate(Long id){
        EmployeeProfile emp=repo.findById(id).orElse(null);
        if(emp!=null){
            emp.setActive(false);
            repo.save(emp);
        }
    }
    @Override
    public EmployeeProfile getById(Long id){
        return repo.findById(id).orElse(null);
    }
    @Override
    public List<EmployeeProfile> getByTeam(String teamName){
        
    }
}