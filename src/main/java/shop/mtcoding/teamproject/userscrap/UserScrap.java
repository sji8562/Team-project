package shop.mtcoding.teamproject.userscrap;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
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
    @Column(nullable = false)
    private Integer userIdx;

    @Column(nullable = false)
    private Integer annIdx;

    @Column(nullable = false)
    private Integer compIdx;

    @Builder
    public UserScrap(Integer index, Integer userIdx, Integer annIdx, Integer compIdx) {

        this.index = index;
        this.userIdx = userIdx;
        this.annIdx = annIdx;
        this.compIdx = compIdx;
    }
}
