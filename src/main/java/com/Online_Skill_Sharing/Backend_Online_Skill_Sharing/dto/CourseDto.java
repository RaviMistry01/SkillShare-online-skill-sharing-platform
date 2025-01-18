package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {
    private int courseId;
    private String courseTitle;
    private String description;
    private int duration;
    private double coursePrice;
    private String instructorUsername; 
}

