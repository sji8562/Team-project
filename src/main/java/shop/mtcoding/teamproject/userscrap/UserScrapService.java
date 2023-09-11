package shop.mtcoding.teamproject.userscrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
