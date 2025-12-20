package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String teamName;

    private boolean active = true;

    // -------- Constructors --------

    public EmployeeProfile() {
    }

    public EmployeeProfile(Long id, String name, String teamName, boolean active) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.active = active;
    }

    // -------- Getters --------

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean isActive() {
        return active;
    }

    // -------- Setters --------

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
