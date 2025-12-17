package com.example.demo.model;

import jakarta.persistance.Entity;
import jakarta.persistance.Id;
import jakarta.persistance.GeneratedValue;
import jakarta.persistance.GenerationType;
import jakarta.persistance.Colomn;

@Entity
public class TeamCapacityConfig{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Colomn(unique=true)
    private String teamName;

    private Integer totalHeadcount;
    private Integer minCapacityPercent;

    public Long getId() {return id;}
    public String getTeamName() {return teamName;}
    public Integer getTotalHeadCount() {return totalHeadcount;}
    public Integer getMinCapacityPercent() {return minCapacityPercent;}
}