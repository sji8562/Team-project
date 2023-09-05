package shop.mtcoding.teamproject.suggest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "suggest_tb")
@Entity
public class Suggest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    
    @Column(nullable = false)
    private Integer resumeIdx;
    
    @Column(nullable = false)
    private Integer compIdx;

    @Column(nullable = false)
    private Integer status;
}
