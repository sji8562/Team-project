package shop.mtcoding.teamproject.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {
    
    
    @Getter @Setter
    public static class userJoinDTO{
        private String userId;
        private String password;
        private String email;
        private String username;
        private String address;
        private String addressDetail;
        private String phoneNum;

        // private MultipartFile pic;
    }
}
