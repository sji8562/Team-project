package shop.mtcoding.teamproject.announcement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String AnnList(Model model){
        
        return "ann/annList";
    }

    @GetMapping("/annDetail")
    public String AnnDetail(){
        return "ann/annDetail";
    }
} 
