package shop.mtcoding.teamproject.company;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.announcement.AnnouncementService;
import shop.mtcoding.teamproject.resume.Resume;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @Autowired
    AnnouncementService announcementService;

    @Autowired
    private HttpSession session;

    private Integer compIndx;

    @GetMapping("/companyJoinForm")
    public String cjoinForm() {
        return "/company/joinForm";
    }

    @GetMapping("/companyLoginForm")
    public String cloginForm() {
        return "/company/loginForm";
    }

    @GetMapping("/companyupdateForm")
    public String cupdate() {
        return "/company/updateForm";
    }

    @PostMapping("/companyJoin")
    public String cjoin(CompanyRequest.compJoinDTO comjoinDTO) {
        companyService.compjoin(comjoinDTO);
        return "/";

    }

    @PostMapping("/companyLogin")
    public void clogin(CompanyRequest.companyLoginDTO compLoginDTO, HttpServletResponse response) throws IOException {
        Company sessioCompany = companyService.companylogin(compLoginDTO);
        session.setAttribute("sessionCompany", sessioCompany);

        response.sendRedirect("/");
    }

    @PostMapping("/companyupdateForm")
    public String update(CompanyRequest.UpdateDTO updateDTO) {

        Company sessionCompany = (Company) session.getAttribute("sessionCompany");
        Company company = companyService.기업정보수정(updateDTO, sessionCompany.getIndex());
        session.setAttribute("sessionCompany", company);
        return "redirect:/companyLoginForm";

    }

    @GetMapping("/compinfoDetail/{id}")
    public String compinfodeatil(@PathVariable Integer id, Model model) {

        Company company = companyService.상세보기(id);
        List<Announcement> announcements = announcementService.채용공고(id);
        model.addAttribute("announcements", announcements);
        System.out.println("=========공고=======");
        model.addAttribute("company", company);
        System.out.println("========기업정보==========");
        return "company/compinfoDetail";
    }

}
