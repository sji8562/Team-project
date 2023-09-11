package shop.mtcoding.teamproject.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import shop.mtcoding.teamproject.apply.Apply;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    @Column(nullable = false, length = 100, unique = true)
    private String userId;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 20)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String addressDetail;

    @Column(nullable = true)
    private String picUrl;

    private int level;

    private Timestamp birthday;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Apply> applies = new ArrayList<>();

    @Builder
    public User(Integer index, String userid, String username, String password, String email, String address,
            String addressDetail, String phoneNum, String picUrl, Timestamp birthday, int level) {

        this.index = index;
        this.userId = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNum;
        this.address = address;
        this.addressDetail = addressDetail;
        this.picUrl = picUrl;
        this.birthday = birthday;
    }

}
