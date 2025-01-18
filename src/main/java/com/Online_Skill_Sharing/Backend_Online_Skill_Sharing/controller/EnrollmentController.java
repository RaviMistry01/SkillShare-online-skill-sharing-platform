package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.EnrollmentDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.EnrollmentService.EnrollmentService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("api/enroll")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;
    
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> enroll(@RequestBody EnrollmentDto enrollmentDto){

        enrollmentService.enroll(enrollmentDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/myenrollments/{userId}")
    public ResponseEntity<List<EnrollmentDto>> viewMyEnrollments(@PathVariable Integer userId){

       List<EnrollmentDto> enrollList =  enrollmentService.viewMyEnrollments(userId);

        return ResponseEntity.ok(enrollList);

    }
}
