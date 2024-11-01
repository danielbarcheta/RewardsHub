package com.rewardshub.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchanges")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User customer; // Referência ao usuário que trocou os pontos

    @ManyToOne
    @JoinColumn(name = "reward_id", nullable = false)
    private Reward reward;

    @Column(name = "exchange_date", nullable = false)
    private LocalDateTime exchangeDate = LocalDateTime.now();

    public Exchange() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public LocalDateTime getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(LocalDateTime exchangeDate) {
        this.exchangeDate = exchangeDate;
    }
}
