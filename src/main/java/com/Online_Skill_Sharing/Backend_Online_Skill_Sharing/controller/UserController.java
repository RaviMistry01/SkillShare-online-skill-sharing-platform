package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.UserDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.User;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceInterface.UserProfileService;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceInterface.UserRegistrationService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRegistrationService userservice;

    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody UserDto userDto) {
        User user = userservice.userRegister(userDto);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UserDto userDto) {
        User user = userProfileService.updateUserDetails(userDto);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/view/{username}")
    public ResponseEntity<UserDto> viewUser(@PathVariable String username) {
        UserDto user = userProfileService.getUserDetails(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
