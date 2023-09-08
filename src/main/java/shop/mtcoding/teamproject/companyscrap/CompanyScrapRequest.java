package shop.mtcoding.teamproject.companyscrap;

import lombok.Getter;
import lombok.Setter;

public class CompanyScrapRequest {

    @Getter
    @Setter
    public static class bookCompanySaveDTO {
        private Integer resumeIdx;
        private Integer compIdx;
    }
}
