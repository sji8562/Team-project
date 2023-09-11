package shop.mtcoding.teamproject.reply;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamproject.board.Board;
import shop.mtcoding.teamproject.company.Company;
import shop.mtcoding.teamproject.user.User;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "reply_tb")
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    @Column(nullable = false, length = 100)
    private String comment;

    @CreationTimestamp
    private Timestamp updateTime;

    @JsonIgnoreProperties({ "password", "email", "updateTime" })
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(targetEntity = Board.class)
    @JoinColumn(name = "board_index")
    private Board board;

    @Builder
    public Reply(Integer index, String comment, Timestamp updateTime, User user, Company company, Board board) {
        this.index = index;
        this.comment = comment;
        this.updateTime = updateTime;
        this.user = user;
        this.company = company;
        this.board = board;
    }

}
