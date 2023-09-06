package shop.mtcoding.teamproject.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject.announcement.AnnouncementRequest;

@Controller
public class HasSkillController {

    @Autowired
    private HasSkillService hasSkillService;

    
    
}
