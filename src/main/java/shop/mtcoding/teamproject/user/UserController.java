package shop.mtcoding.teamproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.teamproject.user.UserRequest.userJoinDTO;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userloginForm")
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
    public String userJoin(UserRequest.userJoinDTO joinDTO){
        userService.usersave(joinDTO);
        return "/";
    }
}
