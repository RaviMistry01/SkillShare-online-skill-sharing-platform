package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.User;



@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    
    User  findByUsername(String username);
    User findByUsernameAndRole(String username , String role);
}
