package shop.mtcoding.teamproject.resume;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "resume_tb")
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    @Column(nullable = false , length = 20)
    private String Title;
    private int education1;
    private int education2;
    private int education3;
    private int education4;

    private String school1;
    private String school2;
    private String school3;
    private String school4;

    private String skill;
    private String introduce;

    private int representedu;

}
