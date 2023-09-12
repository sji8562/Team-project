package shop.mtcoding.teamproject.userscrap;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamproject._core.error.ex.MyApiException;
import shop.mtcoding.teamproject.bigjob.BigJob;

import shop.mtcoding.teamproject.userscrap.UserScrapRequest.bookUserSaveDTO;

@Service
public class UserScrapService {

    @Autowired
    private UserScrapRepository userScrapRepository;

    @Transactional
    public void saveUserScrap(bookUserSaveDTO bSaveDTO) {

        UserScrap userScrap = UserScrap.builder()
                .userIdx(bSaveDTO.getUserIdx())
                .annIdx(bSaveDTO.getAnnIdx())
                .compIdx(bSaveDTO.getCompIdx())
                .build();

        userScrapRepository.save(userScrap);
    }

    // public void UserScrapFindId(bookSaveDTO bSaveDTO, Integer sessionUserIdx) {
    // System.out.println("testestest" + bSaveDTO.getUserIdx());
    // UserScrap userScrap =
    // userScrapRepository.findByUserIdx(bSaveDTO.getUserIdx());
    // System.out.println(userScrap);
    // System.out.println("테스트 : " + userScrap.get());
    // }

    // public boolean isScrapped(bookSaveDTO bSaveDTO, Integer sessionUserId) {
    // // sessionUserId를 사용하여 스크랩한 정보를 가져옵니다.
    // UserScrap userScrap =
    // userScrapRepository.findByUserIdxAndAnnIdx(sessionUserId,
    // bSaveDTO.getAnnIdx());

    // // 만약 UserScrap 객체가 null이 아니라면 이미 스크랩한 것으로 간주합니다.
    // return userScrap != null;
    // }

    public boolean isBookmarkSaved(Integer annIdx, Integer userIdx) {
        UserScrap userScrap = userScrapRepository.findByAnnIdxAndUserIdx(annIdx, userIdx);
        return userScrap != null;
    }

    @Transactional
    public void deleteUserScrap(Integer annIdx, Integer userIdx) {
        UserScrap userScrap = userScrapRepository.findByAnnIdxAndUserIdx(annIdx, userIdx);
        if (userScrap != null) {
            userScrapRepository.delete(userScrap);
        }
    }

}
