package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TeamCapacityConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    private int totalHeadcount;

    // REQUIRED BY TESTS
    private double maxLeavePercent;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalHeadcount() {
        return totalHeadcount;
    }

    public void setTotalHeadcount(int totalHeadcount) {
        this.totalHeadcount = totalHeadcount;
    }

    public double getMaxLeavePercent() {
        return maxLeavePercent;
    }

    public void setMaxLeavePercent(double maxLeavePercent) {
        this.maxLeavePercent = maxLeavePercent;
    }
}
