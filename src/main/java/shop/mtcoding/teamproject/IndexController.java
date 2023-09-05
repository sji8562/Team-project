package shop.mtcoding.teamproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.announcement.AnnouncementService;
import shop.mtcoding.teamproject.company.Company;
import shop.mtcoding.teamproject.company.CompanyService;

@Controller
public class IndexController {

    @Autowired
    private HttpSession session;

    @Autowired
    AnnouncementService announcementService;

    @Autowired
    CompanyService companyService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "0") Integer page1,
            @RequestParam(defaultValue = "0") Integer page2, HttpServletRequest request) {
        Page<Announcement> annPG = announcementService.index공고목록보기(page1);
        Page<Company> comPG = companyService.공고목록보기(page2);
        request.setAttribute("annPG", annPG.getContent());
        request.setAttribute("comPG", comPG.getContent());
        return "/index";
    }

    @GetMapping("/joinselectForm")
    public String joinselectForm() {
        return "/joinselectForm";
    }

    @GetMapping("/loginselectForm")
    public String loginselectForm() {
        return "/loginselectForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
