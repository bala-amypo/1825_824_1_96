package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="capcity_alerts")
public class CapacityAlert{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private LocalDate date;
    private String severity;
    private String message;

    public CapacityAlert(){
    }
    public Long getId() {return id; }
    public void setId(Long id) {this.id=id; }

    public String getTeamName(){return teamName; }
    public void setTeamName(String teamName){this.teamName=teamName; }

    public LocalDate getDate(){return }
}