package shop.mtcoding.teamproject.company;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyRepository companyRepository;

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
    public String cjoin(CompanyRequest.compJoinDTO comjoinDTO) {
        companyService.compjoin(comjoinDTO);
        return "/";
    }

    // @PostMapping("/companyLogin")
    // public void clogin(CompanyRequest.companyLoginDTO compLoginDTO, HttpServletResponse response) throws IOException {
    //     // Company sessioCompany = companyService.companylogin(compLoginDTO);

    //     try {
    //         Company company = companyRepository.findByCompanyId(compLoginDTO.getCompanyId());
    //         boolean isValid = BCrypt.checkpw(compLoginDTO.getPassword(), company.getPassword());
    //         System.out.println("해시로그인 테스트 0 : ");
    //         if (isValid) {

    //             session.setAttribute("sessionCompany", company);

    //             System.out.println("해시로그인 테스트 1 : " + company.getPassword());

    //             response.sendRedirect("/");
    //         } else {
    //             System.out.println("해시로그인 테스트 2 : else");
    //             response.sendRedirect("/");

    //         }
    //     } catch (Exception e) {
    //         System.out.println("해시로그인 테스트 3 : catch");
    //         response.sendRedirect("/");
    //     }

    //     // session.setAttribute("sessionCompany", sessioCompany);

    //     // System.out.println("해시로그인 테스트 4 : " + sessioCompany.getPassword());

    //     // response.sendRedirect("/");
    // }

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
        System.out.println("테스트1" + company.getEmail());
        System.out.println("++++++++++++++비번바꿨다우");
        return "redirect:/companyLoginForm";
    }

    @PostMapping("/company/compinfoUpdate")
    public String compinfoUpdate(CompanyRequest.UpdatedetailDTO updatedetailDTO) {

        Company sessionCompany = (Company) session.getAttribute("sessionCompany");
        System.out.println("테스트 0 : 여기까진 왔니?" + sessionCompany.getIndex());

        Company company = companyService.기업디테일수정(updatedetailDTO, sessionCompany.getIndex());
        System.out.println("테스트 6 :" + company.getPassword());

        session.setAttribute("sessionCompany", company);
        System.out.println("테스트 7 : " + company.getCompanyName());

        return "redirect:/companyinfoDetail";
    }
}
// 수정시에는 영속성 컨텍스트 User오브젝트를 영속화시키고 영속화된 User 오브젝트를 수정
// select해서 User오브젝트를 디비로 부터 가져오는 이유는 영속화를 하기 위해서
// 영속화된 오브젝트를 변경하면 자동으로 디비에 업데이트문을 날려주거든요
// 영속화된 persistance 객체의 변화가 감지되면 더티 체킹