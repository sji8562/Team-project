package shop.mtcoding.teamproject.company;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "company_tb")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    @Column(nullable = false, length = 20, unique = true)
    private String companyId; // 기업 아이디

    @Column(nullable = false, length = 20)
    private String companyName; // 기업명

    @Column(nullable = false, length = 60)
    private String password; // 기업 비밀번호

    @Column(nullable = false, length = 20)
    private String email; // 기업 대표 이메일

    @Column(nullable = true)
    private String picUrl; // 기업 사진

    @Column(nullable = true)
    private String phoneNum; // 기업 대표 번호

    @Column(nullable = true)
    private String address; // 기업 주소

    private String addressDetail; // 기업주소

    private String homepage; // 기업 홈페이지

    private Integer establishment; // 설립연도

    private String businessNum = "11111-1111-111-11111";

    private int level;

    @Builder
    public Company(Integer index, String companyId, String companyName, String password, String email, String picUrl,
            String phoneNum, String address, String addressDetail, String homepage, Integer establishment,
            String businessNum, int level) {
        this.index = index;
        this.companyId = companyId;
        this.companyName = companyName;
        this.password = password;
        this.email = email;
        this.picUrl = picUrl;
        this.phoneNum = phoneNum;
        this.address = address;
        this.addressDetail = addressDetail;
        this.homepage = homepage;
        this.establishment = establishment;
        this.businessNum = businessNum;
        this.level = level;
    }

}
