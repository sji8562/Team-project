package shop.mtcoding.teamproject.skill;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "skill_tb")
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    private String skillName;
    @OneToMany(mappedBy = "skill", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<HasSkill> hasSkill = new ArrayList<>();
    
    public Skill(Integer index, String skillName) {
        this.index = index;
        this.skillName = skillName;
    }

    
}
