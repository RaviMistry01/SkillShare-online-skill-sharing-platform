package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnrollmentDto {

    private int userId;       // User ID of the enrolled user
    private int courseId;     // Course ID of the enrolled course
    private Date enrollmentDate; // Date of enrollment
    private boolean completed; // Enrollment completion status

}

