package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.CourseService;

import java.util.List;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.CourseDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Course;

public interface CourseService {

public  Course registerCourse(CourseDto courseDto);

public CourseDto getCourse(int courseId);

public List<CourseDto> getAllCourse();

public void deleteCourse(int courseId);
    
}
