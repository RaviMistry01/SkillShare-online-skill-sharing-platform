package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.UserDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.User;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.repo.UserRepo;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceInterface.UserProfileService;

@Service
public class UserProfileImpl implements UserProfileService {

  @Autowired
  UserRepo userRepo;

  @Override
  public UserDto getUserDetails(String username) {
    User user = userRepo.findByUsername(username);
    if (user != null) {
      UserDto userDto = new UserDto();
      userDto.setEmail(user.getEmail());
      userDto.setFullname(user.getFullname());
      return userDto;
    }
    return null;
  }

  @Override
  public User updateUserDetails(UserDto userDto) {
    User user = userRepo.findByUsername(userDto.getUsername());
    if (user != null) {
      user.setEmail(userDto.getEmail());
      user.setFullname(userDto.getFullname());
      return userRepo.save(user);
    }
    return null;
  }

  @Override
  public void deleteUser(String username) {
    User user = userRepo.findByUsername(username);
    if (user == null) {
      throw new RuntimeException("User not found with username " + username);
    }
    userRepo.delete(user);
  }
}
