package com.rewardshub.repository;

import com.rewardshub.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Long> {

    public Optional<Business> findByName(String name);
}
