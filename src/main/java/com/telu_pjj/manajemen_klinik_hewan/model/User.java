package com.telu_pjj.manajemen_klinik_hewan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 50) // Adjust length as per your requirements
    private String username;

    @NotBlank
    @Column(nullable = false) // By default, length is 255 for String in JPA
    private String password; // Store hashed passwords

    // Default constructor
    public User() {
    }

    // Constructor with fields
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + '\'' + '}';
    }
}