package shop.mtcoding.teamproject.userscrap;

import lombok.Getter;
import lombok.Setter;

public class UserScrapRequest {

    @Getter
    @Setter
    public static class bookUserSaveDTO {
        private Integer userIdx;
        private Integer annIdx;
        private Integer compIdx;
    }

}
