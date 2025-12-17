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
    private EmployeeProfile employeeProfile;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
}