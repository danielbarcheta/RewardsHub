package com.rewardshub.controller;

import com.rewardshub.model.Reward;
import com.rewardshub.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @PostMapping
    public Reward createReward(@RequestBody Reward reward) {
        return rewardService.createReward(reward);
    }

    @GetMapping
    public List<Reward> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reward> getRewardById(@PathVariable Long id) {
        Reward reward = rewardService.getRewardById(id);
        return ResponseEntity.ok(reward);
    }

    @DeleteMapping("/{id}")
    public void deleteReward(@PathVariable Long id) {
        rewardService.deleteReward(id);
    }
}
