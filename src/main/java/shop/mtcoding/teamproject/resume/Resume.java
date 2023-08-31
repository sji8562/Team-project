package shop.mtcoding.teamproject.resume;


import lombok.Builder;
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

    
    private String Title;

    private String education;

    private String school;

    private String skill;
    @Column(nullable = false, length = 10000)
    private String introduce;

    private String experience;

    private String homepage;

    private boolean status;

    private int userId;
    
    @Builder
    public Resume(Integer index, String title, String education, String school, String skill, String introduce,
            String experience, String homepage, boolean status, int userId) {
        this.index = index;
        Title = title;
        this.education = education;
        this.school = school;
        this.skill = skill;
        this.introduce = introduce;
        this.experience = experience;
        this.homepage = homepage;
        this.status = status;
        this.userId = userId;
    }

    
    
}
