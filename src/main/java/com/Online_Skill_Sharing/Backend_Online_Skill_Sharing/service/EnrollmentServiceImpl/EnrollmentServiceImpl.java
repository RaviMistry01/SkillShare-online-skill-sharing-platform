package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.EnrollmentServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.EnrollmentDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.exception.CourseNotFoundException;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.exception.UserNotFoundException;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Course;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.Enrollment;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.User;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.CourseRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.EnrollmentRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.UserRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.EnrollmentService.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    EnrollmentRepo enrollmentRepo;

    @Override
    public void enroll(EnrollmentDto enrollmentDto) {

        User user = userRepo.findById(enrollmentDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("cannot find user with Id :" + enrollmentDto.getUserId()));
        Course course = courseRepo.findById(enrollmentDto.getCourseId()).orElseThrow(
                () -> new CourseNotFoundException("cannot find course with Id :" + enrollmentDto.getCourseId()));

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setCompleted(enrollmentDto.isCompleted());
        enrollmentRepo.save(enrollment);

    }

    @Override
    public List<EnrollmentDto> viewMyEnrollments(int userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("cannot find user with Id :" + userId));
        List<Enrollment> enrollments = enrollmentRepo.findByUserId(userId);

        return enrollments.stream()
                .map(enrollment -> new EnrollmentDto(
                        enrollment.getUser().getUserid(),
                        enrollment.getCourse().getCourse_id(),
                        enrollment.getEnrollmentdate(),
                        enrollment.isCompleted()

                )).collect(Collectors.toList());

    }

}
