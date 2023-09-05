package shop.mtcoding.teamproject.announcement;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject.skill.HasSkill;
import shop.mtcoding.teamproject.skill.HasSkillService;
import shop.mtcoding.teamproject.skill.Skill;
import shop.mtcoding.teamproject.skill.SkillService;
import shop.mtcoding.teamproject.skill.HasSkillRequest.annSaveDTO;

@Controller
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private HasSkillService hasSkillService;

    @GetMapping("/annSaveForm")
    public String annSaveForm(Model model) {
        List<Skill> skills = skillService.스킬목록보기();
        model.addAttribute("skills", skills);
        return "ann/annSave";
    }

    @PostMapping("/annSave")
    public String annSave(Announcement announcement, Skill skills) {
        announcementService.공고등록(announcement);

        HasSkill hasSkill = new HasSkill();
        hasSkill.setAnnouncement(announcement);
        hasSkill.setSkill(skills);
        hasSkillService.등록(hasSkill);

        return "redirect:/annlist";
    }

    @GetMapping("/annUpdateForm/{id}")
    public String annUpdateForm(@PathVariable Integer id, Model model){
        List<Skill> skills = skillService.스킬목록보기();
        Announcement ann = announcementService.공고상세보기(id);
        model.addAttribute("ann", ann);
        model.addAttribute("skills", skills);
        return "ann/annUpdate";
    }

    @PostMapping("/annUpdate/{id}")
    public String annUpdate(@PathVariable Integer id, AnnouncementRequest.UpdateDTO updateDTO, Skill skills){
         announcementService.공고수정(id, updateDTO);
         hasSkillService.공고스킬수정(id, skills);
        return "redirect:/annDetail/" + id;
    }

    @GetMapping("/annlist")
    public String annList(@RequestParam(defaultValue = "0") Integer page, HttpServletRequest request) {
        Page<Announcement> annPG = announcementService.공고목록보기(page);
        request.setAttribute("annPG", annPG.getContent());
        request.setAttribute("prevPage", annPG.getNumber() - 1);
        request.setAttribute("nextPage", annPG.getNumber() + 1);

        return "ann/annList";
    }

    @GetMapping("/annDetail/{id}")
    public String AnnDetail(@PathVariable Integer id, Model model) {
        Announcement ann = announcementService.공고상세보기(id);
        model.addAttribute("ann", ann);
        return "ann/annDetail";
    }

    @PostMapping("/annDelete/{id}")
    public String annDelete(@PathVariable Integer id) {
        System.out.println("컨트롤러는 돌아가나???????????");
        announcementService.공고삭제(id);
        return "redirect:/annlist";
    }

}
