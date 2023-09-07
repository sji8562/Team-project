package shop.mtcoding.teamproject.user;

import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Generated;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserRequest {

    @Getter
    @Setter
    public static class userJoinDTO {
        private String userId;
        private String password;
        private String email;
        private String username;
        private String address;
        private String addressDetail;
        private String phoneNum;

        // private MultipartFile pic;
    }

    @Getter
    @Setter
    public static class userLoginDTO {
        private String userId;
        private String password;
    }

    @Data
    @Getter
    @Setter
    public static class OAuthToken {
        private String access_token;
        private String token_type;
        private String id_token;
        private String refresh_token;
        private Integer expires_in;
        private String scope;
        private Integer refresh_token_expires_in;
    }

    @Data
    public static class KakaoAccount {

        public Boolean profile_nickname_needs_agreement;
        public Boolean profile_image_needs_agreement;
        public Profile profile;
        public Boolean has_email;
        public Boolean email_needs_agreement;
        public Boolean is_email_valid;
        public Boolean is_email_verified;
        public String email;
        public Boolean has_birthday;
        public Boolean birthday_needs_agreement;
        public String birthday;
        public String birthday_type;

    }

    @Data
    @NoArgsConstructor
    public static class Kakaologin {

        public Long id;
        public String connected_at;
        public Properties properties;
        public KakaoAccount kakao_account;

    }

    @Data
    public static class Profile {

        public String nickname;
        public String thumbnail_image_url;
        public String profile_image_url;
        public Boolean is_default_image;

    }

    @Data
    public static class Properties {

        public String nickname;
        public String profile_image;
        public String thumbnail_image;

    }
}
