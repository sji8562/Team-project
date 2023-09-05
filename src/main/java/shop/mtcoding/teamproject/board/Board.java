package shop.mtcoding.teamproject.board;

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
@Getter
@Setter
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    private Integer type;

    private String title;
    private String content;
    private Integer count;
    private Timestamp updateTime;
    private Integer userIdx;
    private Integer compIdx;

    @Builder
    public Board(Integer index, Integer type, String title, String content, Integer count, Timestamp updateTime,
            Integer userIdx, Integer compIdx) {
        this.index = index;
        this.type = type;
        this.title = title;
        this.content = content;
        this.count = count;
        this.updateTime = updateTime;
        this.userIdx = userIdx;
        this.compIdx = compIdx;
    }
}
