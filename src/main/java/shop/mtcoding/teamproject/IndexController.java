package shop.mtcoding.teamproject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String index(){
        return "/index";
    }
    @GetMapping("/joinselectForm")
    public String joinselectForm(){
        return "/joinselectForm";
    } 
    @GetMapping("/loginselectForm")
    public String loginselectForm(){
        return "/loginselectForm";
    } 
    
    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        return "redirect:/";
    }
}
