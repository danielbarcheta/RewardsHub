package com.rewardshub.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "points_required", nullable = false)
    private Integer pointsRequired;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    public Reward() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPointsRequired() {
        return pointsRequired;
    }

    public void setPointsRequired(Integer pointsRequired) {
        this.pointsRequired = pointsRequired;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name) && Objects.equals(description, reward.description) && Objects.equals(pointsRequired, reward.pointsRequired) && Objects.equals(business, reward.business);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, pointsRequired, business);
    }

    // Getters e Setters
}
