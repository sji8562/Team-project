package shop.mtcoding.teamproject.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
    @GetMapping("/companyjoinForm")
    public String cjoin(){
        return "/company/joinForm";
    }
    @GetMapping("/companyupdateForm")
    public String cupdate(){
        return "/company/updateForm";
    }
    
}
