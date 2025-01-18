package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.service.ContentService;

import com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto.ContentDto;

public interface ContentService {
    
    public void uploadContent(ContentDto contentDto);

    public ContentDto downloadContent(int contentId);
}
