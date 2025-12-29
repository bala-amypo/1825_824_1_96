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
    private int maxCapacity;

    public TeamCapacityConfig() {}

    public TeamCapacityConfig(String teamName, int maxCapacity){
        this.teamName=teamName;
        this.maxCapacity=maxCapacity;
    }
    public Long getId(){
        return id;
    }
    
}
