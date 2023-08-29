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

    private String eduName;
    private String workType;
    private String salary;
    private String location;
    private Timestamp startTime;
    private Timestamp endTime;
    private String form;
    private String manager;
    private String compId;
    private String bigJobId;
    private String smallJobId;
    private String userId;

}
