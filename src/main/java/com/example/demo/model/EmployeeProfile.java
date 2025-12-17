package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "employee_profile",
    UniqueConstraints = {
        @UniqueConstraint(columnNames = "employeeId"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class EmployeeProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String fullname;
    private String email;
    private String teamName;
    private String role;
    private boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}
    public String getEmployeeId() {return employeeId;}
    public void setEmployeeId(String employeeId) {this.employeeId=employeeId;}
    public String getFullName(String fullname) {return fullname;}
    public void setFullName(String fullname) {this.fullname=fullname;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email=email;}
    public String getTeamName() {return teamName;}
    public void setTeamName(String teamName) {this.teamName=teamName;}
    public String getRole() {return role;}
    public void setRole(String role) {this.role=role;}
    public boolean isActive() {return active;} 
}