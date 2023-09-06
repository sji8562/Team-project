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

    @PostMapping("/companyupdateForm")
    public String update(CompanyRequest.UpdateDTO updateDTO) {

        Company sessionCompany = (Company) session.getAttribute("sessionCompany");
        Company company = companyService.기업정보수정(updateDTO, sessionCompany.getIndex());
        session.setAttribute("sessionCompany", company);
        System.out.println("++++++++++++++비번바꿨다우");
        return "redirect:/companyLoginForm";

    }

}
// 수정시에는 영속성 컨텍스트 User오브젝트를 영속화시키고 영속화된 User 오브젝트를 수정
// select해서 User오브젝트를 디비로 부터 가져오는 이유는 영속화를 하기 위해서
// 영속화된 오브젝트를 변경하면 자동으로 디비에 업데이트문을 날려주거든요
// 영속화된 persistance 객체의 변화가 감지되면 더티 체킹