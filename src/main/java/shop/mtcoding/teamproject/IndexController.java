package shop.mtcoding.teamproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
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
    
}
