package com.example.tripplanner.entity;

import jakarta.persistence.*; // Това е магията на базите данни

@Entity
@Table(name = "app_users") // В базата таблицата ще се казва "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    // --- Конструктори ---
    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // --- Getters и Setters (Нужни са, за да достъпваме данните) ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}