package com.rewardshub.repository;

import com.rewardshub.model.BusinessUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusinessUserRepository extends JpaRepository<BusinessUser, Long> {
    List<BusinessUser> findByBusinessId(Long businessId);
    void deleteByUserIdAndBusinessId(Long userId, Long businessId);

    Optional<BusinessUser> findByUserEmailAndBusinessIdAndRole(String username, Long businessId, String admin);
}
