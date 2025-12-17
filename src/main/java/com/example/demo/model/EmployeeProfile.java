package com.example.demo.model;

import jakarta.persistance.Entity;
import jakarta.persistance.Table;
import jakarta.persistance.Id;
import jakarta.persistance.GeneratedValue;
import jakarta.persistance.GenerationType;
import jakarta.persistance.Column;
import jakarta.persistance.UniqueConstraint;
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
    public String getEmail() {} 
}