package shop.mtcoding.teamproject.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/userloginForm")
    public String loginForm(){
        return "/user/loginForm";
    }
    @GetMapping("/userjoinForm")
    public String joinForm(){
        return "/user/joinForm";
    }
    @GetMapping("/userupdateForm")
    public String updateForm(){
        return "/user/updateForm";
    }
}
