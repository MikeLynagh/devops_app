package com.example.web_app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Petition {
    private static long counter = 0;
    private long id;
    private String title;
    private String description;
    private int targetSignatures;
    private List<Signature> signatures = new ArrayList<>();
    private LocalDateTime createdAt;

    public Petition(String title, String description, int targetSignatures) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
        this.targetSignatures = targetSignatures;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTargetSignatures() {
        return targetSignatures;
    }

    public void setTargetSignatures(int targetSignatures) {
        this.targetSignatures = targetSignatures;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }

    public int getCurrentSignatureCount() {
        return signatures.size();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}