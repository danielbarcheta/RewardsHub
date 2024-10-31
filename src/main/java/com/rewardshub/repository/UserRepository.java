package com.rewardshub.repository;

import com.rewardshub.model.ModelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ModelUser, Long> {

    Optional<ModelUser> findByEmail(String email);

}