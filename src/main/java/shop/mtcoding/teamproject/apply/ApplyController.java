package shop.mtcoding.teamproject.apply;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject._core.error.ex.MyApiException;
import shop.mtcoding.teamproject._core.util.ApiUtil;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.apply.ApplyRequest.ListDTO;
import shop.mtcoding.teamproject.resume.Resume;
import shop.mtcoding.teamproject.user.User;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private HttpSession session;

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

    @GetMapping("/apply")
    public String applyList(Model model){
        ListDTO listDTO = applyService.지원목록보기();
        List<Apply> applies = listDTO.getApplies();
        List<Resume> resume = listDTO.getResumes();
        List<Announcement> ann = listDTO.getAnnouncements();

        model.addAttribute("resume", resume);
        model.addAttribute("ann", ann);
        model.addAttribute("applies", applies);
        return "/appsgg/userAppSggList";
    }
   
}
