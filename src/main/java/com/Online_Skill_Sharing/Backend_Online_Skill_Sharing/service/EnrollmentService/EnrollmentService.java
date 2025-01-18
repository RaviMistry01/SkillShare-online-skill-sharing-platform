package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.EnrollmentService;

import java.util.List;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.EnrollmentDto;

public interface EnrollmentService {

    void enroll(EnrollmentDto enrollmentDto);

    List<EnrollmentDto> viewMyEnrollments(int userId);
    
}
