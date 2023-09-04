package shop.mtcoding.teamproject.skill;

import javax.persistence.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announcement_index")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    private Announcement announcement;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_index")
    private Skill skill;
    @ManyToOne(fetch = FetchType.LAZY)
    private Resume resume;
}
