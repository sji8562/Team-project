package shop.mtcoding.teamproject.user;

import java.io.IOException;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

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

    @GetMapping("/userupdateForm")
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
        session.setAttribute("sessionUser", sessionUser);
        response.sendRedirect("/");
    }

}
