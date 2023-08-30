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
    @Column(nullable = false , length = 20, unique = true)
    private String id;  //기업 아이디

    @Column(nullable = false, length = 20)
    private String companyName;  //기업명

    @Column(nullable = false, length = 60)
    private String password; //기업 비밀번호

    @Column(nullable = false, length = 20)
    private String email; //기업 대표 이메일

    @Column(nullable = true)
    private String picUrl; //기업 사진

    @Column(nullable = true)
    private String phoneNumber; //기업 대표 번호

    @Column(nullable = true)
    private String address1;  //기업 주소

    private String address2;  //기업주소

    private String homepage; //기업 홈페이지

    private String AnnouncementId;  //채용공고 1:N 관계 하나의 기업은 많은 공고를 낼 수 있다
    
    private Timestamp establishment;  //설립연도

    
    private String resumeId; //이력서 N:N 기업은 많은 이력서를 볼 수 있고 많은 이력서를 받을수있다

    @Builder
    public Company(Integer index, String companyName, String password, String email, String picUrl, Timestamp establishment) {
        this.index = index;
        this.companyName = companyName;
        this.password = password;
        this.email = email;
        this.picUrl = picUrl;
        this.establishment = establishment;
    }

}

