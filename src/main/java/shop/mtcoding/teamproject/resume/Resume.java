package shop.mtcoding.teamproject.resume;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamproject.apply.Apply;
import shop.mtcoding.teamproject.skill.HasSkill;
import shop.mtcoding.teamproject.user.User;

import java.util.ArrayList;
import java.util.List;

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
    @Lob
    @Column(nullable = true)
    private String introduce;
    private String experience;
    private String homepage;
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Apply> applies = new ArrayList<>();
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HasSkill> hasSkill = new ArrayList<>();

    @Builder
    public Resume(Integer index, String title, String education, String school, String skill, String introduce,
            String experience, String homepage, boolean status, User user, List<HasSkill> hasSkill) {
        this.index = index;
        Title = title;
        this.education = education;
        this.school = school;
        this.skill = skill;
        this.introduce = introduce;
        this.experience = experience;
        this.homepage = homepage;
        this.status = status;
        this.user = user;
        this.hasSkill = hasSkill;
    }

   
    

    
    
}
