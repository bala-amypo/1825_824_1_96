package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TeamCapacityConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    private int maxLeavePercent;

    // ---------- Constructors ----------

    public TeamCapacityConfig() {
    }

    public TeamCapacityConfig(Long id, String teamName, int maxLeavePercent) {
        this.id = id;
        this.teamName = teamName;
        this.maxLeavePercent = maxLeavePercent;
    }

    // ---------- Getters ----------

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getMaxLeavePercent() {
        return maxLeavePercent;
    }

    // ---------- Setters ----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setMaxLeavePercent(int maxLeavePercent) {
        this.maxLeavePercent = maxLeavePercent;
    }
}
