package shop.mtcoding.teamproject.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    @Column(nullable = false, length = 20, unique = true)
    private String id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 20)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String address1;

    @Column(nullable = true)
    private String address2;

    @Column(nullable = true)
    private String picUrl;

    private String homepage;

    private int level;

    private Timestamp birthday;

    @Builder
    public User(Integer index, String username, String password, String email, String picUrl, Timestamp birthday) {
        this.index = index;
        this.username = username;
        this.password = password;
        this.email = email;
        this.picUrl = picUrl;
        this.birthday = birthday;
    }
}