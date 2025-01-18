package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Enrollment;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer>{


    
    @Query("SELECT e FROM Enrollment e WHERE e.user.id = :userId")
    List<Enrollment> findByUserId(@Param("userId") int userId);
}
