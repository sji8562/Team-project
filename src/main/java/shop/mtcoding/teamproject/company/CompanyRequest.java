package shop.mtcoding.teamproject.company;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class CompanyRequest {

    @Getter
    @Setter
    public static class compJoinDTO {
        private String companyId;
        private String companyName;
        private String password;
        private String email;
        private String address;
        private String addressDetail;
        private String phoneNum;
        private String homepage;

        // private MultipartFile pic;
    }

    @Getter
    @Setter
    public static class companyLoginDTO {
        private String companyId;
        private String password;
    }

    @Getter
    @Setter
    public static class UpdateDTO {
        private String companyName;
        private String password;
        private String email;
        private String address;
        private String addressDetail;
        private String phoneNum;
        private String homepage;
    }

    @Getter
    @Setter
    public static class UpdatedetailDTO {
        private String companyName;
        private Integer establishment;
        private String address;
        private String addressDetail;
        private String phoneNum;
        private String email;
        private String homepage;
    }
}
