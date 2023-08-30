package shop.mtcoding.teamproject.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {
    @GetMapping("/comunitylist")
    public String comunitylist(){
        return "comunity/comunitylist";
    }

    @GetMapping("/comunitywrite")
    public String comunitywrite(){
        return "comunity/comunityWrite";
    }
    
}
