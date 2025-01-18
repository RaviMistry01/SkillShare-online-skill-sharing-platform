package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto {
    
    private int user_id;
    private int course_id;
    private int rating;
    private String comment;
    private Date date;
}
