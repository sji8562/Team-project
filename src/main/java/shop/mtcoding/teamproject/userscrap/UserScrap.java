package shop.mtcoding.teamproject.userscrap;



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
@Table(name = "user_scrap_tb")
@Entity
public class UserScrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    @Column(nullable = false, length = 20)
    private Integer userIdx;

    @Column(nullable = false, length = 20)
    private Integer annIdx;
    
    @Column(nullable = false, length = 20)
    private Integer compIdx;
}
