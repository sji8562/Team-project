package shop.mtcoding.teamproject.skill;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.teamproject.reply.Reply;

public interface HasSkillRepository extends JpaRepository<HasSkill, Integer> {

     
    
}
