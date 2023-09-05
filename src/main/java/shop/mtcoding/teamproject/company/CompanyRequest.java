package shop.mtcoding.teamproject.company;

import lombok.Getter;
import lombok.Setter;

public class CompanyRequest {
    
    @Getter @Setter
    public static class compJoinDTO{
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
    public static class companyLoginDTO{
        private String companyId;
        private String password;
    }
    
}
