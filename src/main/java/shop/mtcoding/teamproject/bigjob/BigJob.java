package shop.mtcoding.teamproject.bigjob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "big_job_tb")
@Entity
public class BigJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    
    private String bigName;  //대분류 이름
}
