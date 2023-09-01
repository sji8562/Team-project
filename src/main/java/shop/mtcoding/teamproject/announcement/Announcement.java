package shop.mtcoding.teamproject.announcement;

import lombok.Builder;
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
    
    @OneToMany(mappedBy="announcement", fetch = FetchType.LAZY)
    private String compIdx;  // 1:N 관계 회사는 많은 공고를 올릴수있다 
    @OneToMany(mappedBy="announcement", fetch = FetchType.LAZY)
    private String bigJobIdx; //1:1 관계 공고는 하나의 대분류를 가지고있다.
    @OneToMany(mappedBy="announcement", fetch = FetchType.LAZY)
    private String smallJobIdx;  //1:1관계 공고는 하나의 소분류를 가지고있다.

    @Builder
    public Announcement(Integer index, String workType, String experience, String graduation, String task,
            String location, Timestamp startTime, Timestamp endTime, String salary, String skill, String preference,
            String managerName, String position, String pic, String workTime, String workDay, String compId,
            String bigJobId, String smallJobId) {
        this.index = index;
        this.workType = workType;
        this.experience = experience;
        this.graduation = graduation;
        this.task = task;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.salary = salary;
        this.skill = skill;
        this.preference = preference;
        this.managerName = managerName;
        this.position = position;
        this.pic = pic;
        this.workTime = workTime;
        this.workDay = workDay;
        this.compIdx = compIdx;
        this.bigJobIdx = bigJobIdx;
        this.smallJobIdx = smallJobIdx;
    }

    
}
