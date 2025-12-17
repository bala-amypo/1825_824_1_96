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

    private String 
}