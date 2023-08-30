package shop.mtcoding.teamproject.announcement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "announcement_tb")
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    private String career; //경력

    private String education; //학력

    private String workType; //근무형태

    private String salary; //급여

    private String location; //근무지역
    private String position; //직급
    private Timestamp startTime; //접수시작시간
    private Timestamp endTime;  //접수 마감시간
    private String form; //접수양식
    private String manager; //대표번호
    private String compId;  // 1:N 관계 회사는 많은 공고를 올릴수있다 
    private String bigJobId; //1:1 관계 공고는 하나의 대분류를 가지고있다.
    private String smallJobId;  //1:1관계 공고는 하나의 소분류를 가지고있다.
    private String userId; 

}