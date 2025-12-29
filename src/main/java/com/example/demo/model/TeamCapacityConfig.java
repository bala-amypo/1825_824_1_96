package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team_capacity_config")
public class TeamCapacityConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String teamName;

    @Column(nullable = false)
    private int totalHeadcount;

    @Column(nullable = false)
    private int minCapacityPercent;

    @Column(nullable = false)
    private int maxCapacity;

    public TeamCapacityConfig() {}

    public TeamCapacityConfig(String teamName, int totalHeadcount, int minCapacityPercent, int maxCapacity){
        this.teamName=teamName;
        this.maxCapacity=maxCapacity;
        this.totalHeadcount=totalHeadcount;
        this.minCapacityPercent=minCapacityPercent;
    }
    public Long getId(){
        return id;
    }
    public String getTeamName(){
        return teamName;
    }
    public int totalHeadcount(){
        return totalHeadcount;
    }
    public int getMaxCapacity(){
        return maxCapacity;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setTeamName(String teamName){
        this.teamName=teamName;
    }
    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity=maxCapacity;
    }
}
