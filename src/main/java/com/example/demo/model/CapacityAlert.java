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
    
}