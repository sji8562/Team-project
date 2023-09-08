package shop.mtcoding.teamproject.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject._core.error.ex.MyApiException;
import shop.mtcoding.teamproject._core.util.ApiUtil;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.resume.Resume;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @PostMapping("/api/apply/save")
    public @ResponseBody ApiUtil<String> applySave(Resume resume, Announcement announcement){
        try {
            applyService.지원등록(resume, announcement);
            return new ApiUtil<String>(true, "지원이 완료되었습니다");
        } catch (MyApiException e) {
            throw new MyApiException("지원이 완료되지 않았습니다");
        }
    }
   
}
