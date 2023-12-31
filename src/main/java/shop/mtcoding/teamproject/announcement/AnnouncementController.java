package shop.mtcoding.teamproject.announcement;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject.resume.Resume;
import shop.mtcoding.teamproject.resume.ResumeService;
import shop.mtcoding.teamproject.skill.HasSkill;
import shop.mtcoding.teamproject.skill.HasSkillService;
import shop.mtcoding.teamproject.skill.Skill;
import shop.mtcoding.teamproject.skill.SkillService;
import shop.mtcoding.teamproject.skill.HasSkillRequest.annSaveDTO;
import shop.mtcoding.teamproject.user.User;
import shop.mtcoding.teamproject.userscrap.UserScrapService;

@Controller
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private HasSkillService hasSkillService;
    @Autowired
    private HttpSession session;

    @Autowired
    private UserScrapService userScrapService;

    @GetMapping("/annSaveForm")
    public String annSaveForm(Model model) {
        List<Skill> listA = skillService.스킬리스트보기(1, 10);
        List<Skill> listB = skillService.스킬리스트보기(11, 22);
        List<Skill> listC = skillService.스킬리스트보기(23, 28);
        List<Skill> listD = skillService.스킬리스트보기(29, 34);

        model.addAttribute("listA", listA);
        model.addAttribute("listB", listB);
        model.addAttribute("listC", listC);
        model.addAttribute("listD", listD);

        return "ann/annSave";
    }

    @PostMapping("/annSave")
    public void annSave(AnnouncementRequest.SaveDTO saveDTO, Skill skills, HttpServletResponse response)
            throws IOException {
        Announcement ann = announcementService.공고등록(saveDTO);
        hasSkillService.공고스킬등록(ann, skills);
        response.sendRedirect("/ann/annlist");

    }

    @GetMapping("/annUpdateForm/{id}")
    public String annUpdateForm(@PathVariable Integer id, Model model) {
        List<Skill> listA = skillService.스킬리스트보기(1, 10);
        List<Skill> listB = skillService.스킬리스트보기(11, 22);
        List<Skill> listC = skillService.스킬리스트보기(23, 28);
        List<Skill> listD = skillService.스킬리스트보기(29, 34);

        model.addAttribute("listA", listA);
        model.addAttribute("listB", listB);
        model.addAttribute("listC", listC);
        model.addAttribute("listD", listD);

        Announcement ann = announcementService.공고상세보기(id);
        model.addAttribute("ann", ann);
        return "ann/annUpdate";
    }

    @PostMapping("/annUpdate/{id}")
    public void annUpdate(@PathVariable Integer id, AnnouncementRequest.UpdateDTO updateDTO, Skill skills,
            HttpServletResponse response) throws IOException {
        announcementService.공고수정(id, updateDTO);
        hasSkillService.공고스킬수정(id, skills);
        response.sendRedirect("/annDetail/" + id);

    }

    @GetMapping("/ann/annlist")
    public String annList(@RequestParam(defaultValue = "0") Integer page, HttpServletRequest request) {
        Page<Announcement> annPG = announcementService.공고목록보기(page);
        request.setAttribute("annPG", annPG.getContent());
        request.setAttribute("prevPage", annPG.getNumber() - 1);
        request.setAttribute("nextPage", annPG.getNumber() + 1);

        return "ann/annList";
    }

    @GetMapping("/annDetail/{id}")
    public String AnnDetail(@PathVariable Integer id, Model model) {
        User user = (User) session.getAttribute("sessionUser");
        Announcement ann = announcementService.공고상세보기(id);
        Integer sessionUserId = null;
        Integer annIdx = null;
        boolean isBookmarked = false;
        if (user != null) {
            sessionUserId = user.getIndex();

            annIdx = id; // Replace with the actual announcement index
        }
        if (sessionUserId != null && !sessionUserId.equals("")) {
            isBookmarked = userScrapService.isBookmarkSaved(annIdx, sessionUserId);
        }

        model.addAttribute("isBookmarked", isBookmarked);
        model.addAttribute("ann", ann);
        return "ann/annDetail";
    }

    @PostMapping("/annDelete/{id}")
    public void annDelete(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        announcementService.공고삭제(id);

        hasSkillService.공고스킬삭제(id);
        response.sendRedirect("/ann/list");

    }

}
