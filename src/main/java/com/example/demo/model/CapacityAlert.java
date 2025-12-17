package com.example.demo.model;

import jakarta.persistance.Entity;
import jakarta.persistance.Id;
import jakarta.persistance.GeneratedValue;
import jakarta.persistance.GenerationType;
import java.time.LocalDate;

@Entity
public class CapacityAlert{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private LocalDate date;
    private String severity;
    private String message;

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}
    public String getTeamName() {return teamName;}
    public void setTeamName(String teamName) {this.teamName=teamName;}
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate data) {this.date=date;}
    public String getSeverity() {return severity;}
    public void setSeverity(String severity) {this.severity=severity;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message=message;}
    
}