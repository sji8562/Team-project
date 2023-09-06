package shop.mtcoding.teamproject.skill;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.resume.Resume;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "HasSkill_tb")
@Entity
public class HasSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "announcement_index")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    private Announcement announcement;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "resume_index")
    private Resume resume;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "skill_index")
    private Skill skill;

    @Builder
    public HasSkill(Integer index, Announcement announcement, Resume resume, Skill skill) {
        this.index = index;
        this.announcement = announcement;
        this.resume = resume;
        this.skill = skill;
    }
    
    
}
