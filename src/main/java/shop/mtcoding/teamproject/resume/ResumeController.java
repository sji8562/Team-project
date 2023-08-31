package shop.mtcoding.teamproject.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @GetMapping("/resList")
    public String resumeList() {
        return "resume/resumeList";
    }

    @GetMapping("/resSaveForm")
    public String resumeSaveForm() {
        return "resume/resumeSave";
    }

    @PostMapping("/resSave")
    public String resumeSave(Resume resume){
        resumeService.이력서등록(resume);
        return "resume/resumeDetail";
    }


    @GetMapping("resDetail")
    public String resumeDetail() {
        return "resume/resumeDetail";
    }

    @GetMapping("/resUpdateForm")
    public String resumeUpdateForm() {
        return "resume/resumeUpdate";
    }

}
