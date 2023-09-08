package shop.mtcoding.teamproject.companyscrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject._core.util.ApiUtil;
import shop.mtcoding.teamproject.companyscrap.CompanyScrapRequest.bookCompanySaveDTO;

@Controller
public class CompanyScrapController {

    @Autowired
    private CompanyScrapService companyScrapService;

    @PostMapping("/api/CompanyScrap/save")
    public @ResponseBody ApiUtil<String> saveCompanyScrap(
            @RequestBody bookCompanySaveDTO bcSaveDTO) {
        System.out.println(bcSaveDTO.getCompIdx());
        System.out.println(bcSaveDTO.getResumeIdx());
        companyScrapService.savecompanyScrap(bcSaveDTO);
        return new ApiUtil<String>(true, "북마크 성공");
    }

    @DeleteMapping("/api/companyScrap/delete")
    public @ResponseBody String deleteUserScrap(@RequestParam Integer resumeIdx, @RequestParam Integer compIdx) {
        companyScrapService.deleteCompanyScrap(resumeIdx, compIdx);
        return "/";
    }
}
