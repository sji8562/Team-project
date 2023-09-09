package shop.mtcoding.teamproject.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public @ResponseBody ApiUtil<String> applySave(@RequestBody ApplyRequest.SaveDTO saveDTO){
        String annId = saveDTO.getAnnId();
        Integer annIndex = Integer.valueOf(annId);
        try {
            applyService.지원등록(saveDTO.getResume(), annIndex);
            return new ApiUtil<String>(true, "지원이 완료되었습니다");
        } catch (Exception e) {
            if (e.getCause() instanceof javax.persistence.PersistenceException ) {
                throw new MyApiException("이미 지원한 공고입니다");
            } else {
                throw new MyApiException("지원이 완료되지 않았습니다");
            }
        }
    }
   
}
