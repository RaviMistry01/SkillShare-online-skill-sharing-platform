package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.CourseServiceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.CourseDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.UserDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.exception.CourseNotFoundException;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Course;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.User;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.CourseRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.UserRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.CourseService.CourseService;


@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    UserRepo userRepo;
    
    @Override
    public Course registerCourse(CourseDto courseDto) {
       
        Course existingCourse = courseRepo.findById(courseDto.getCourseId()).orElse(null);
        User instructor = userRepo.findByUsernameAndRole(courseDto.getInstructorUsername(),"INSTRUCTOR");

        if(existingCourse !=null){
            return null;
        }

        Course course = courseDtoToCourse(courseDto);
        course.setInstuctor(instructor);
        
        return courseRepo.save(course);
        
       
    }

    @Override
    public CourseDto getCourse(int courseId) {
      
        Course  course = courseRepo.findById(courseId).orElse(null);
        
        if (course != null) 
        {
            CourseDto courseDto = courseToCourseDto(course);
            return courseDto;
        }

        return null;        
        

    }

    @Override
    public List<CourseDto> getAllCourse() {
        
        List<Course> courses = courseRepo.findAll();

        return courses.stream()
            .map(course->new CourseDto(
                course.getCourse_id(),
                course.getCourseTitle(),
                course.getDescription(),
                course.getDuration(),
                course.getCoursePrice(),
                course.getInstuctor().getFullname()
            )).collect(Collectors.toList());
                                
    }
    
    private CourseDto courseToCourseDto(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(course.getCourse_id());
        courseDto.setCoursePrice(course.getCoursePrice());
        courseDto.setCourseTitle(course.getCourseTitle());
        courseDto.setDescription(course.getDescription());
        courseDto.setInstructorUsername(course.getInstuctor().getFullname());
        
        return courseDto;

    }

    private Course courseDtoToCourse(CourseDto courseDto){
        Course course = new Course();
       
        course.setCoursePrice(courseDto.getCoursePrice());
        course.setCourseTitle(courseDto.getCourseTitle());
        course.setDescription(courseDto.getDescription());
        course.setDuration(courseDto.getDuration());

        return course;
    }

    @Override
    public void deleteCourse(int courseId) {
        Course course = courseRepo.findById(courseId).orElseThrow(()->new CourseNotFoundException("cannot find course with course Id : "+courseId));


        courseRepo.deleteById(courseId);
    }
}
