package shop.mtcoding.teamproject.skill;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.teamproject.reply.Reply;

public interface HasSkillRepository extends JpaRepository<HasSkill, Integer> {
    @Query(value = "select * from Has_Skill_tb where announcement_index = :announcement_index", nativeQuery = true)
    HasSkill findByAnnIdx(@Param("announcement_index") Integer announcement_index);

    @Query(value = "select * from Has_Skill_tb where resume_index = :resume_index", nativeQuery = true)
    HasSkill findByresIdx(@Param("resume_index") Integer resume_index);
     
    
}
