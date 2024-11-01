package com.rewardshub.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "businesses")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "business")
    private List<BusinessUser> businessUsers;

    @OneToMany(mappedBy = "business")
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "business")
    private List<Reward> rewards;

    public Business() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<BusinessUser> getBusinessUsers() {
        return businessUsers;
    }

    public void setBusinessUsers(List<BusinessUser> businessUsers) {
        this.businessUsers = businessUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return Objects.equals(name, business.name) && Objects.equals(address, business.address) && Objects.equals(businessUsers, business.businessUsers) && Objects.equals(purchases, business.purchases) && Objects.equals(rewards, business.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, purchases, rewards);
    }


}
