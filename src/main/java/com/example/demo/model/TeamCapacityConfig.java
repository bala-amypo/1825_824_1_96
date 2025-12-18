package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class TeamCapacityConfig{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String teamName;

    private Integer totalHeadcount;
    private Integer minCapacityPercent;

    public Long getId() {return id;}
    public String getTeamName() {return teamName;}
    public Integer getTotalHeadCount() {return totalHeadcount;}
    public Integer getMinCapacityPercent() {return minCapacityPercent;}
}