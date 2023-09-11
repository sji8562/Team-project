package shop.mtcoding.teamproject.user;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject.bigjob.BigJob;
import shop.mtcoding.teamproject.bigjob.BigJobService;
import shop.mtcoding.teamproject.userscrap.UserScrap;
import shop.mtcoding.teamproject.userscrap.UserScrapService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserScrapService userScrapService;

    @Autowired
    private BigJobService bigJobService;

    @GetMapping("/user/kakao")
    public @ResponseBody String kakao(String code, HttpServletResponse response)
            throws IOException {
        // POST방식으로 key=value 데이터를 요청(카카오쪽으로 )
        // Retrofit2 안드로이드에서 많이 씀
        // OkHttp
        // RestTemplate

        User sessionUser = userService.kakaologin(code);
        session.setAttribute("sessionUser", sessionUser);
        response.sendRedirect("/");
        return "로그인 완료";

    }

    @GetMapping("/userLoginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("/userJoinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/userUpdateForm")
    public String updateForm() {
        return "/user/updateForm";
    }

    @PostMapping("/userJoin")
    public void userJoin(UserRequest.userJoinDTO joinDTO, HttpServletResponse response) throws IOException {
        userService.usersave(joinDTO);
        response.sendRedirect("/userloginForm");
    }

    @PostMapping("/userLogin")
    public void userLogin(UserRequest.userLoginDTO loginDTO, HttpServletResponse response) throws IOException {
        User sessionUser = userService.userlogin(loginDTO);
        if (sessionUser != null) {
            // 사용자가 입력한 비밀번호와 DB에 저장된 해시화된 비밀번호를 비교
            boolean isValid = BCrypt.checkpw(loginDTO.getPassword(), sessionUser.getPassword());

            if (isValid) {
                // 비밀번호가 일치하는 경우 세션에 저장
                session.setAttribute("sessionUser", sessionUser);
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

    // @PostMapping("/user/scrapList")
    // public String userScraplist(Integer userindex, HttpServletRequest request) {
    // if (userindex != null) {
    // System.out.println("테스트 1 " + userindex);
    // List<UserScrap> userScraps = userScrapService.scrapList(userindex);
    // System.out.println(userScraps.get(0));
    // request.setAttribute("list", userScraps);
    // } else {
    // return "/index";
    // }
    // return "/userscrap/userscrapList";
    // }
}