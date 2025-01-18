package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.CourseDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Course;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.CourseRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.CourseService.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {
    
    @Autowired
    CourseService courseService;
 
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerCourse(@RequestBody CourseDto courseDto){
       Course course =  courseService.registerCourse(courseDto);

       if (course != null) {
       return ResponseEntity.status(HttpStatus.OK).build();
        
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/view/{courseId}")
    public  ResponseEntity<CourseDto> getCourse(@PathVariable int courseId){
       CourseDto dto =  courseService.getCourse(courseId);

       if (dto != null) {
        return ResponseEntity.ok(dto);
       }
       return ResponseEntity.notFound().build();

    }

    @GetMapping("/view/allCourses")
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        List<CourseDto> dtoList = courseService.getAllCourse();

        if(dtoList !=null){
            return ResponseEntity.ok(dtoList);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int courseId){
        courseService.deleteCourse(courseId);

       return ResponseEntity.status(HttpStatus.OK).build();
    }

}
