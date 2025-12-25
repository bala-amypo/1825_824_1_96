package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TeamCapacityConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private int totalHeadcount;
    private int minCapacityPercent;   // TEST EXPECTS THIS

    // ===== REQUIRED GETTERS =====

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTotalHeadcount() {
        return totalHeadcount;
    }

    public int getMinCapacityPercent() {
        return minCapacityPercent;
    }

    // ===== REQUIRED SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTotalHeadcount(int totalHeadcount) {
        this.totalHeadcount = totalHeadcount;
    }

    public void setMinCapacityPercent(int minCapacityPercent) {
        this.minCapacityPercent = minCapacityPercent;
    }
}
