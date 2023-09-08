package shop.mtcoding.teamproject.userscrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject._core.util.ApiUtil;

@Controller
public class UserScrapController {

    @Autowired
    private UserScrapService userScrapService;

    @PostMapping("/api/userScrap/save")
    public @ResponseBody ApiUtil<String> saveUserScrap(@RequestBody UserScrapRequest.bookUserSaveDTO bSaveDTO) {
        userScrapService.saveUserScrap(bSaveDTO);
        return new ApiUtil<String>(true, "북마크 성공");
    }

    @DeleteMapping("/api/userScrap/delete")
    public @ResponseBody String deleteUserScrap(@RequestParam Integer annIdx, @RequestParam Integer userIdx) {
        userScrapService.deleteUserScrap(annIdx, userIdx);
        return "/";
    }
}