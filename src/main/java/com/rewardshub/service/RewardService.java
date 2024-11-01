package com.rewardshub.service;


import com.rewardshub.model.Reward;
import com.rewardshub.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    public Reward createReward(Reward reward) {
        return rewardRepository.save(reward);
    }

    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    public Reward getRewardById(Long id) {
        return rewardRepository.findById(id).orElse(null);
    }

    public void deleteReward(Long id) {
        rewardRepository.deleteById(id);
    }
}
