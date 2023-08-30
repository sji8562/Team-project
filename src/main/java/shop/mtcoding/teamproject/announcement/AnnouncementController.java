package shop.mtcoding.teamproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnouncementController {
    
    @GetMapping("/annsave")
    public String Annsave(){
        return "ann/insertAnn";
    }
    @GetMapping("/annupdate")
    public String Annupdate(){
        return "ann/updateAnn";
    }
    @GetMapping("/annlist")
    public String Annlist(){
        return "ann/listAnn";
    }
}
