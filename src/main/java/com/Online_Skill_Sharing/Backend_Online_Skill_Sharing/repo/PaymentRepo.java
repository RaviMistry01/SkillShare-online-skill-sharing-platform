package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Payment;


@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {

    
} 