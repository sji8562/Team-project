package shop.mtcoding.teamproject.company;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
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
    CompanyRepository companyRepository;
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
    public String cupdate(HttpServletRequest request) {
        Company sessionUser = (Company) session.getAttribute("sessionCompany");
        System.out.println("테스트1" + sessionUser.getCompanyId());
        Company user = companyService.회원정보보기(sessionUser.getIndex());
        request.setAttribute("company", user);
        System.out.println("테스트2" + user.getCompanyId());

        return "/company/updateForm";
    }

    @GetMapping("/companyDetailForm")
    public String cdetailForm(HttpServletRequest request) {
        Company sessionUser = (Company) session.getAttribute("sessionCompany");
        System.out.println("테스트1" + sessionUser.getCompanyId());
        Company user = companyService.회원정보보기(sessionUser.getIndex());
        request.setAttribute("company", user);
        System.out.println("테스트2" + user.getCompanyId());

        return "/company/compinfoDetail";
    }

    @GetMapping("/company/compinfoUpdateForm")
    public String compinfoUpdateForm() {
        return "/company/compinfoUpdate";
    }

    @PostMapping("/companyJoin")
    public void cjoin(CompanyRequest.compJoinDTO comjoinDTO, HttpServletResponse response) throws IOException {
        companyService.compjoin(comjoinDTO);
        response.sendRedirect("/companyLoginForm");

    }

    @PostMapping("/companyLogin")
    public void clogin(CompanyRequest.companyLoginDTO compLoginDTO, HttpServletResponse response) throws IOException {
        Company sessioCompany = companyService.companylogin(compLoginDTO);

        if (sessioCompany != null) {
            // 사용자가 입력한 비밀번호와 DB에 저장된 해시화된 비밀번호를 비교
            boolean isValid = BCrypt.checkpw(compLoginDTO.getPassword(), sessioCompany.getPassword());

            if (isValid) {
                // 비밀번호가 일치하는 경우 세션에 저장
                session.setAttribute("sessionCompany", sessioCompany);
                System.out.println("해시 로그인 성공");
            } else {
                // 비밀번호가 일치하지 않는 경우 로그인 실패 처리
                System.out.println("해시 로그인 실패: 비밀번호 불일치");
            }
        } else {
            // 사용자 정보를 찾을 수 없는 경우 로그인 실패 처리
            System.out.println("해시 로그인 실패: 사용자 정보 없음");
        }

        response.sendRedirect("/");
    }

    @PostMapping("/companyupdateForm")
    public String update(CompanyRequest.UpdateDTO updateDTO) {
        Company sessionCompany = (Company) session.getAttribute("sessionCompany");
        Company company = companyService.기업정보수정(updateDTO, sessionCompany.getIndex());
        session.setAttribute("sessionCompany", company);
        return "redirect:/companyLoginForm";

    }

    @PostMapping("/company/compinfoUpdate")
    public String compinfoUpdate(CompanyRequest.UpdatedetailDTO updatedetailDTO) {
        Company sessionCompany = (Company) session.getAttribute("sessionCompany");
        Company company = companyService.기업디테일수정(updatedetailDTO, sessionCompany.getIndex());
        session.setAttribute("sessionCompany", company);

        return "redirect:/companyinfoDetail";
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
