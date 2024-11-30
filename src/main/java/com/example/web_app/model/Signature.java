package com.example.web_app.model;

import java.time.LocalDateTime;

public class Signature {
    private String name;
    private String email;
    private LocalDateTime signedAt;

    public Signature(String name, String email) {
        this.name = name;
        this.email = email;
        this.signedAt = LocalDateTime.now();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getSignedAt() {
        return signedAt;
    }
}