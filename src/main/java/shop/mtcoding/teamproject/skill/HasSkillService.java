package shop.mtcoding.teamproject.skill;

import javax.transaction.Transactional;

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
    
    @Transactional
    public void 등록(HasSkill hasSkill) {
        hasSkillRepository.save(hasSkill);
    }

    @Transactional
    public HasSkill 스킬수정(Integer annId, Skill skills) {
        HasSkill hasSkill = hasSkillRepository.findByAnnIdx(annId);
        hasSkill.setSkill(skills);
        return hasSkill;
    }

    
    
}
