package shop.mtcoding.teamproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnouncementController {
    
    @GetMapping("/annsave")
    public String Annsave(){
        return "ann/annSave";
    }
    @GetMapping("/annupdate")
    public String Annupdate(){
        return "ann/annUpdate";
    }
    @GetMapping("/annlist")
    public String Annlist(){
        return "ann/annList";
    }

    @GetMapping("/anndetail")
    public String Anndatil(){
        return "ann/annDetail";
    }
} 
