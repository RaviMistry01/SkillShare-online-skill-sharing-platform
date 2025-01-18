package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    
    private String username;
    private String email;
    private String password;
    private String fullname;
    private String Role;

}
