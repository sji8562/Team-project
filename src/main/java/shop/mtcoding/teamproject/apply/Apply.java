package shop.mtcoding.teamproject.apply;

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
@Table(name = "apply_tb")
@Entity
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    
    @Column(nullable = false)
    private Integer annIdx;
    
    @Column(nullable = false)
    private Integer resumeIdx;

    @Column(nullable = false)
    private Integer status;
}
