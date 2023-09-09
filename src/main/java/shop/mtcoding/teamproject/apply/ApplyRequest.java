package shop.mtcoding.teamproject.apply;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.resume.Resume;

public class ApplyRequest {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class SaveDTO{
        private Resume resume;
        private String annId;
    }

    @Getter
    @Setter
    public static class ListDTO{
        private List<Resume> resumes;
        private List<Announcement> announcements;
        private List<Apply> applies;
    }
}
