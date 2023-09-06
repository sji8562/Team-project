package shop.mtcoding.teamproject.company;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @Autowired
    private HttpSession session;

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

    @GetMapping("companyDetailForm")
    public String cdetailForm() {
        return "/company/compinfoDetail";
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

}
