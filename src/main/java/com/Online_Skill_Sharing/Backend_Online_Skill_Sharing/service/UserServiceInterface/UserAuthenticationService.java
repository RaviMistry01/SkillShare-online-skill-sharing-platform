package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.UserServiceInterface;

public interface UserAuthenticationService {
   public String authenticateUser(String username, String password);

   public Boolean logoutUser(String username);
}
