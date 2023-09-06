package shop.mtcoding.teamproject.skill;

import java.util.List;

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
    public HasSkill 공고스킬수정(Integer annId, Skill skills) {
        HasSkill hasSkill = hasSkillRepository.findByAnnIdx(annId);
        hasSkill.setSkill(skills);
        return hasSkill;
    }
    @Transactional
    public List<HasSkill> 이력서스킬수정(Integer resId, Skill skills) {
        List<HasSkill> hasSkills = hasSkillRepository.findByresIdx(resId);
        for (HasSkill hasSkill : hasSkills) {
            hasSkill.setSkill(skills);
            hasSkillRepository.save(hasSkill);
        }
        return hasSkills;
    }

    public List<HasSkill> 이력서스킬목록(Integer id){
        List<HasSkill> hasSkills = hasSkillRepository.findByresIdx(id);
        return hasSkills;
    }

    
    
}
