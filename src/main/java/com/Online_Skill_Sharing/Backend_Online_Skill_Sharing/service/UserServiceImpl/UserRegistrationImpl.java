package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.UserDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.exception.DuplicateUsernameException;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.User;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.UserRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceInterface.UserRegistrationService;


@Service
public class UserRegistrationImpl implements UserRegistrationService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User userRegister(UserDto userDto) {

        try{

            User user = dtoToEntity(userDto);
            userRepo.save(user);
            return user;
        }
       catch(DataIntegrityViolationException e){
        throw new DuplicateUsernameException("Username '" + userDto.getUsername() + "' is already taken.");
       }

    }

    private User dtoToEntity(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFullname(dto.getFullname());
        user.setRole(dto.getRole());
        return user;
    }
    
}
