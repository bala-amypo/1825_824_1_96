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
    @GeneratedValue(strategy=GenerationType)
}