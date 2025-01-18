package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceInterface;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.UserDto;
import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model.User;

public interface UserProfileService {
    public UserDto getUserDetails(String Username);
    public User updateUserDetails(UserDto userDto);
    public void deleteUser(String username);
}
