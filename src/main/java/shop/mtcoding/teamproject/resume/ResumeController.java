package shop.mtcoding.teamproject.resume;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.mtcoding.teamproject.skill.HasSkill;
import shop.mtcoding.teamproject.skill.HasSkillService;
import shop.mtcoding.teamproject.skill.Skill;
import shop.mtcoding.teamproject.skill.SkillService;
import shop.mtcoding.teamproject.user.User;

import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private HasSkillService hasSkillService;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private HttpSession session;

    @GetMapping("/resList")
    public String resumeList(Model model) {
        List<Resume> res = resumeService.이력서목록보기();
        model.addAttribute("res", res);
        return "resume/resumeList";
    }

    @GetMapping("/resSaveForm")
    public String resumeSaveForm(Model model) {
        List<Skill> listA = skillService.스킬리스트보기(1, 10);
        List<Skill> listB = skillService.스킬리스트보기(11, 22);
        List<Skill> listC = skillService.스킬리스트보기(23, 28);
        List<Skill> listD = skillService.스킬리스트보기(29, 34);

        model.addAttribute("listA", listA);
        model.addAttribute("listB", listB);
        model.addAttribute("listC", listC);
        model.addAttribute("listD", listD);

        return "resume/resumeSave";
    }

    @PostMapping("/resSave")
    public String resumeSave(Resume res, Skill skills) {
        resumeService.이력서등록(res);
        hasSkillService.이력서스킬등록(res, skills);

        return "redirect:/resList";
    }

    @GetMapping("/resDetail/{id}")
    public String resumeDetail(@PathVariable Integer id, Model model) {
        Resume resume = resumeService.이력서상세보기(id);
        User user = resumeService.이력서유저보기(resume);
        List<HasSkill> hasSkills = hasSkillService.이력서스킬목록(id);

        model.addAttribute("res", resume);
        model.addAttribute("user", user);
        model.addAttribute("skills", hasSkills);
        return "resume/resumeDetail";
    }

    @GetMapping("/resUpdateForm/{id}")
    public String resumeUpdateForm(@PathVariable Integer id, Model model) {
        List<Skill> skills = skillService.스킬목록보기();
        Resume res = resumeService.이력서상세보기(id);
        model.addAttribute("res", res);
        model.addAttribute("skills", skills);
        return "resume/resumeUpdate";
    }

    @PostMapping("/resUpdate/{id}")
    public String resumeUpdate(@PathVariable Integer id, Resume res, Skill skills) {
        resumeService.이력서수정(id,  res);
        hasSkillService.이력서스킬수정(id, skills);
        return "redirect:/resDetail/" + id;
    }

    @PostMapping("/resDelete/{id}")
    public String resumeDelete(@PathVariable Integer id) {
        resumeService.이력서삭제(id);
        return "redirect:/resList";
    }

}
