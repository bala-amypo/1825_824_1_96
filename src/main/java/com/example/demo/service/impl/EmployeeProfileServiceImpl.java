package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfileDto create(EmployeeProfileDto dto) {
        EmployeeProfile entity = new EmployeeProfile();
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setTeamName(dto.getTeamName());
        entity.setRole(dto.getRole());
        entity.setActive(true);

        EmployeeProfile saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public EmployeeProfileDto update(Long id, EmployeeProfileDto dto) {
        EmployeeProfile entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        if (dto.getFullName() != null) entity.setFullName(dto.getFullName());
        if (dto.getTeamName() != null) entity.setTeamName(dto.getTeamName());
        if (dto.getRole() != null) entity.setRole(dto.getRole());

        EmployeeProfile saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public void deactivate(Long id) {
        EmployeeProfile entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        entity.setActive(false);
        repository.save(entity);
    }

    @Override
    public EmployeeProfileDto getById(Long id) {
        EmployeeProfile entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        return toDto(entity);
    }

    @Override
    public List<EmployeeProfileDto> getByTeam(String teamName) {
        return repository.findByTeamNameAndActiveTrue(teamName)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeProfileDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * ✅ FINAL FIX — NO DUPLICATES + RETURNS ALL COLLEAGUES
     */
    @Override
    public List<EmployeeProfileDto> addColleagues(Long id, List<Long> colleagueIds) {

        EmployeeProfile employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        List<EmployeeProfile> newColleagues = colleagueIds.stream()
                .map(colleagueId -> repository.findById(colleagueId)
                        .orElseThrow(() -> new ResourceNotFoundException("Colleague not found")))
                .filter(colleague -> !employee.getColleagues().contains(colleague)) // prevent duplicates
                .collect(Collectors.toList());

        employee.getColleagues().addAll(newColleagues);
        repository.save(employee);

        // 🔥 RETURN ALL COLLEAGUES (this fixes the last failing test)
        return employee.getColleagues().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private EmployeeProfileDto toDto(EmployeeProfile entity) {
        EmployeeProfileDto dto = new EmployeeProfileDto();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setTeamName(entity.getTeamName());
        dto.setRole(entity.getRole());
        return dto;
    }
}
