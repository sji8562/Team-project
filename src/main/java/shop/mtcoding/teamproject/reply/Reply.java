package shop.mtcoding.teamproject.reply;

import java.sql.Timestamp;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "reply_tb")
@Entity
public class Reply {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    private String comment;

    private Timestamp updateTime;

    private Integer userIdx;

    private Integer compIdx;

    private Integer boardIdx;
}
