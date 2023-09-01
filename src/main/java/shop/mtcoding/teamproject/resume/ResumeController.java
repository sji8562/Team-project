package shop.mtcoding.teamproject.resume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

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
    public String resumeDetail() {
        return "resume/resumeDetail";
    }

    @GetMapping("/resUpdateForm/{id}")
    public String resumeUpdateForm() {
        return "resume/resumeUpdate";
    }

}
