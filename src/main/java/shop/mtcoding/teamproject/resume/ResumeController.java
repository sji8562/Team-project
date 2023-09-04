package shop.mtcoding.teamproject.resume;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private HttpSession session;

    @GetMapping("/resList")
    public String resumeList(Model model) {
        List<Resume> res = resumeService.이력서목록보기();
        model.addAttribute("res", res);
        return "resume/resumeList";
    }

    @GetMapping("/resSaveForm")
    public String resumeSaveForm() {
        return "resume/resumeSave";
    }

    @PostMapping("/resSave")
    public String resumeSave(Resume res) {
        resumeService.이력서등록(res);
        return "redirect:/resList";
    }

    @GetMapping("/resDetail/{id}")
    public String resumeDetail(@PathVariable Integer id, Model model) {
        Resume resume = resumeService.이력서상세보기(id);
        model.addAttribute("res", resume);
        return "resume/resumeDetail";
    }

    @GetMapping("/resUpdateForm/{id}")
    public String resumeUpdateForm(@PathVariable Integer id, Model model) {
        Resume res = resumeService.이력서상세보기(id);
        model.addAttribute("res", res);
        return "resume/resumeUpdate";
    }

    @PostMapping("/resUpdate/{id}")
    public String resumeUpdate(@PathVariable Integer id, Resume res) {
        resumeService.이력서수정(id,res);
        return "redirect:/resDetail/"+id;
    }

    @PostMapping("/resDelete/{id}")
    public String resumeDelete(@PathVariable Integer id){
        resumeService.이력서삭제(id);
        return "redirect:/resList";
    }
    

}