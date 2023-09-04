package shop.mtcoding.teamproject.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject.announcement.AnnouncementService;

@Service
public class HasSkillService {
    @Autowired
    private HasSkillRepository hasSkillRepository;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private SkillService skillService;

    public void 등록(HasSkill hasSkill) {
        hasSkillRepository.save(hasSkill);
    }
    
}
