package com.example.demo.model;

import jakarta.persistance.Entity;
import jakarta.persistance.Id;
import jakarta.persistance.GeneratedValue;
import jakarta.persistance.GenerationType;
import jakarta.persistance.Colomn;
import jakarta.persistance.OneToOne;

@Entity
public class UserAccount{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Colomn(unique=true)
    private String username;

    @Colomn(unique=true)
    private String email;

    private String password;
    private String role;

    @OneToOne
}