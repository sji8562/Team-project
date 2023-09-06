package shop.mtcoding.teamproject.skill;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    @Query(value = "select * from skill_tb where index between :index1 and :index2", nativeQuery = true)
    List<Skill> findByList(@Param("index1") Integer index1, @Param("index2") Integer index2);
}
