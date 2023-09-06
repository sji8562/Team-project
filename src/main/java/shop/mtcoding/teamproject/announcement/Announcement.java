package shop.mtcoding.teamproject.announcement;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamproject.apply.Apply;
import shop.mtcoding.teamproject.bigjob.BigJob;
import shop.mtcoding.teamproject.company.Company;
import shop.mtcoding.teamproject.skill.HasSkill;
import shop.mtcoding.teamproject.smalljob.SmallJob;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "announcement_tb")
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    private String title;
    private String workType; // 근무형태

    private String experience; // 경력

    private String graduation; // 학력
    private String task; // 직무
    private String location; // 근무지역
    private Timestamp updateTime;
    private Timestamp startTime; // 접수시작시간
    private Timestamp endTime; // 접수 마감시간
    private String salary; // 급여
    private String preference; // 우대조건
    private String managerName; // 대표자
    private String position; // 직급
    private String pic;
    private String workTime;
    private String workDay;

    private String compIdx; // 1:N 관계 회사는 많은 공고를 올릴수있다
    private String bigJobIdx; // 1:1 관계 공고는 하나의 대분류를 가지고있다.
    private String smallJobIdx; // 1:1관계 공고는 하나의 소분류를 가지고있다.

    @OneToMany(mappedBy = "announcement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HasSkill> skills = new ArrayList<>();
    @OneToMany(mappedBy="announcement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Apply> applies = new ArrayList<>();
    // 아직 컴퍼니 더미데이터 없어서 Integer, company로 나중에 바꿔야함
    private Integer company_id; // 1:N 관계 회사는 많은 공고를 올릴수있다
    @ManyToOne(fetch = FetchType.LAZY)
    private BigJob bigJob;
    @ManyToOne(fetch = FetchType.LAZY)
    private SmallJob smallJob; // 1:1관계 공고는 하나의 소분류 가지고있다.

    @Builder
    public Announcement(Integer index, String title, String workType, String experience, String graduation, String task,
            String location, Timestamp startTime, Timestamp endTime, String salary, String preference,
            String managerName, String position, String pic, String workTime, String workDay, Integer company_id,
            BigJob bigJob, SmallJob smallJob) {
        this.index = index;
        this.title = title;
        this.workType = workType;
        this.experience = experience;
        this.graduation = graduation;
        this.task = task;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.salary = salary;
        this.preference = preference;
        this.managerName = managerName;
        this.position = position;
        this.pic = pic;
        this.workTime = workTime;
        this.workDay = workDay;
        this.company_id = company_id;
        this.bigJob = bigJob;
        this.smallJob = smallJob;
    }

}
