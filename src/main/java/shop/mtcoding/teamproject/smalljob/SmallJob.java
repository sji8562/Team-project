package shop.mtcoding.teamproject.smalljob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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


    private int bigJobIdx;
}

