package com.example.demo.model;

import jakarta.persistance.Entity;
import jakarta.persistance.Id;
import jakarta.persistance.GeneratedValue;
import jakarta.persistance.GenerationType;
import jakarta.persistance.ManyToOne;
import java.time.LocalDate;

@Entity
public class LeaveRequest{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EmployeeProfile employee;

    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private String status;
    private String reason;

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}
    public EmployeeProfile getEmployee() {return employee;}
    public void setEmployee(EmployeeProfile employee) {this.employee=employee;}
    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate=startDate;}
    public LocalDate getEndDate() {return endDate;}
}