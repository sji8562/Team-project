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

    private String workType; //근무형태

    private String experience; //경력

    private String graduation; //학력
    private String task; //직무
    private String location; //근무지역
    private Timestamp startTime; //접수시작시간
    private Timestamp endTime;  //접수 마감시간
    private String salary; //급여
    private String skill; //기술
    private String preference; //우대조건
    private String managerName; //대표자
    private String position; //직급
    private String pic;
    private String workTime;
    private String workDay;
    
    
    private String compIdx;  // 1:N 관계 회사는 많은 공고를 올릴수있다 
    private String bigJobIdx; //1:1 관계 공고는 하나의 대분류를 가지고있다.
    private String smallJobIdx;  //1:1관계 공고는 하나의 소분류를 가지고있다.

}
