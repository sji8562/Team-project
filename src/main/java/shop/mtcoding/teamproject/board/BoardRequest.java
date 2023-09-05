package shop.mtcoding.teamproject.board;

import lombok.Getter;
import lombok.Setter;

public class BoardRequest {

    @Getter
    @Setter
    public static class UpdateDTO {
        private String title;
        private String content;
    }

    @Getter
    @Setter
    public static class SaveDTO {
        private String title;
        private String content;

    }
}
