package shop.mtcoding.teamproject.reply;

import lombok.Getter;
import lombok.Setter;

public class ReplyRequest {
    @Getter
    @Setter
    public static class SaveDTO {
        private Integer boardId;
        private String comment;
    }

}
