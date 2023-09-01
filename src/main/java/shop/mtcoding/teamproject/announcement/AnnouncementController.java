package shop.mtcoding.teamproject.announcement;

import java.util.List;

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

@Controller
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;
    
    @GetMapping("/annSaveForm")
    public String annSaveForm(){
        return "ann/annSave";
    }

    @PostMapping("/annSave")
    public String annSave(Announcement announcement){
        announcementService.공고등록(announcement);
        return "redirect:/ann/annList"; 
    }
    @GetMapping("/annUpdateForm")
    public String annUpdateForm(Announcement announcement, Model model){

        return "ann/annUpdate";
    }

    @PostMapping("/annUpdate")
    public String annUpdate(Announcement announcement){
        
        return "redirect:/ann/annDetail";
    }
    @GetMapping("/annlist")
    public String annList(@RequestParam(defaultValue = "0")Integer page, HttpServletRequest request){
        Page<Announcement> annPG = announcementService.공고목록보기(page);
        request.setAttribute("annPG", annPG);
        request.setAttribute("prevPage", annPG.getNumber()-1);
        request.setAttribute("nextPage", annPG.getNumber()+1);
        
        return "ann/annList";
    }

    @GetMapping("/annDetail/{id}")
    public String AnnDetail(@PathVariable Integer id, Model model){
        Announcement ann = announcementService.공고상세보기(id);
        model.addAttribute("ann", ann);
        return "ann/annDetail";
    }
} 
