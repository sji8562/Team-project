package shop.mtcoding.teamproject.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
  @Autowired
  private SkillRepository skillRepository;

  public List<Skill> 스킬목록보기() {
    return skillRepository.findAll();
  }

   public List<Skill> 스킬리스트보기(Integer index1, Integer index2){
    return skillRepository.findByList(index1, index2);
   }

  

  public Skill 스킬상세보기(Integer index) {
    return skillRepository.findById(index).get();
  }
}
