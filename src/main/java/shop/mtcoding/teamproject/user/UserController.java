package shop.mtcoding.teamproject.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;


    @GetMapping("/userLoginForm")
    public String loginForm(){
        return "/user/loginForm";
    }
    @GetMapping("/userJoinForm")
    public String joinForm(){
        return "/user/joinForm";
    }
    @GetMapping("/userupdateForm")
    public String updateForm(){
        return "/user/updateForm";
    }


    @PostMapping("/userJoin")
    public void userJoin(UserRequest.userJoinDTO joinDTO,HttpServletResponse response) throws IOException{
        userService.usersave(joinDTO);
        response.sendRedirect("/userloginForm");
    }
    

    @PostMapping("/userLogin")
    public void userLogin(UserRequest.userLoginDTO loginDTO,HttpServletResponse response) throws IOException{
        User sessionUser = userService.userlogin(loginDTO);
        session.setAttribute("sessionUser", sessionUser);
        response.sendRedirect("/");
    }
    
}
