package shop.mtcoding.teamproject.smalljob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamproject.bigjob.BigJob;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "small_job_tb")
@Entity
public class SmallJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    private String smallName;

    @ManyToOne
    @JoinColumn(name = "bigJobIdx", referencedColumnName = "index")
    private BigJob bigJob;
}
