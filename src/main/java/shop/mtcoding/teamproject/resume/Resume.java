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

    private int education;

    private String school;

    private String skill;

    private String introduce;

    private String experience;

    private String homepage;

    private boolean status;

    private int userId;
    
}
