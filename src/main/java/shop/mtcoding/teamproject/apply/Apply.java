package shop.mtcoding.teamproject.apply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.resume.Resume;
import shop.mtcoding.teamproject.user.User;

@NoArgsConstructor
@Setter
@Getter

@Table(name = "apply_tb", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "user_index", "announcement_index" }) })

@Entity
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_index")
    private Announcement announcement;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_index")
    private Resume resume;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_index")
    private User user;

    @Column(nullable = false)
    private Integer status;

    @Builder
    public Apply(Integer index, Announcement announcement, Resume resume, User user, Integer status) {
        this.index = index;
        this.announcement = announcement;
        this.resume = resume;
        this.user = user;
        this.status = status;
    }

}
