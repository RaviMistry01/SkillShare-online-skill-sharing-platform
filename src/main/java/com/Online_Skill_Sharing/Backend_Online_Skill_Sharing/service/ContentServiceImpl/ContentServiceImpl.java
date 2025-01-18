package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.ContentServiceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.ContentDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.exception.CourseNotFoundException;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Course;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.ContentRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.CourseRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.ContentService.ContentService;

public class ContentServiceImpl implements ContentService{

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ContentRepo contentRepo;

    @Override
    public void uploadContent(ContentDto contentDto) {
       
        MultipartFile file = contentDto.getFile();
        String title = contentDto.getTitle();
        String description = contentDto.getDescription();
        int courseId = contentDto.getCourse_id();


        //check whether the course exist in course repo

     
            Optional<Course> optionalCourse = courseRepo.findById(courseId);

            if(optionalCourse.isEmpty()){
                throw new CourseNotFoundException("Cannot find course with id :"+courseId);
            }

            Course course = optionalCourse.get();
            String filename = file.getOriginalFilename();
       


        throw new UnsupportedOperationException("Unimplemented method 'uploadContent'");
    }

    @Override
    public ContentDto downloadContent(int contentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'downloadContent'");
    }
    
}
