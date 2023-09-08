package shop.mtcoding.teamproject.userscrap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamproject._core.error.ex.MyApiException;
import shop.mtcoding.teamproject._core.util.ApiUtil;
import shop.mtcoding.teamproject.userscrap.UserScrapRequest.bookSaveDTO;

@Controller
public class UserScrapController {

    @Autowired
    private UserScrapService userScrapService;
    @Autowired
    private HttpSession session;

    @PostMapping("/api/userScrap/save")
    public @ResponseBody ApiUtil<String> saveUserScrap(@RequestBody UserScrapRequest.bookSaveDTO bSaveDTO) {
        userScrapService.saveUserScrap(bSaveDTO);
        return new ApiUtil<String>(true, "북마크 성공");
    }

    @DeleteMapping("/api/userScrap/delete")
    public @ResponseBody String deleteUserScrap(@RequestParam Integer annIdx, @RequestParam Integer userIdx) {
        userScrapService.deleteUserScrap(annIdx, userIdx);
        return "/";
    }

    // @DeleteMapping("/api/reply/{id}/delete")
    // public @ResponseBody ApiUtil<String> delete(@PathVariable Integer id) {
    // // 1. 인증체크
    // UserScrap sessionUser = (UserScrap) session.getAttribute("sessionUser");
    // if (sessionUser == null) {
    // throw new MyApiException("인증되지 않았습니다");
    // }

    // // 2. 핵심로직
    // // userScrapService.bookdelete(id, sessionUser.getIndex());

    // // 3. 응답
    // return new ApiUtil<String>(true, "댓글삭제 완료");
    // }

}