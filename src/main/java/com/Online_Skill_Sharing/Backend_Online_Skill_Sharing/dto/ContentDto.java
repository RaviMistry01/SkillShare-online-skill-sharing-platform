package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContentDto {
    
    private int course_id;
    private String title;
    private String description;
    private String url;
    private MultipartFile file;
    private Date contentDate;
}
