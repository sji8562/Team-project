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
    private String id;

    @Column(nullable = false, length = 20)
    private String compname;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 20)
    private String email;

    @Column(nullable = true)
    private String picUrl;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String address;

    private String homepage;

    private String Announcement;

    private Timestamp establishment;

    @Builder
    public Company(Integer index, String compname, String password, String email, String picUrl, Timestamp establishment) {
        this.index = index;
        this.compname = compname;
        this.password = password;
        this.email = email;
        this.picUrl = picUrl;
        this.establishment = establishment;
    }

}

