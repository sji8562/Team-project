package shop.mtcoding.teamproject.apply;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.announcement.AnnouncementRepository;
import shop.mtcoding.teamproject.resume.Resume;
import shop.mtcoding.teamproject.resume.ResumeRepository;
import shop.mtcoding.teamproject.user.User;
import shop.mtcoding.teamproject.user.UserRepository;
import shop.mtcoding.teamproject.user.UserService;

@Service
public class ApplyService {
    @Autowired
    private ApplyRepository applyRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private ResumeRepository resumeRepository;

    public void 지원등록(Resume resume, Integer annId){
        User user = (User) session.getAttribute("sessionUser");
        Integer resId = resume.getIndex();
        Resume resume2 = resumeRepository.findById(resId).get();
        Apply apply = Apply.builder()
                    .user(userRepository.findById(user.getIndex()).get())
                    .resume(resume2)
                    .announcement(announcementRepository.findById(annId).get())
                    .status(3)
                    .build();

        applyRepository.save(apply);
    }
}
