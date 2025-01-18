package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    Course findByCourseTitle(String title);
    
} 