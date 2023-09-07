package shop.mtcoding.teamproject.resume;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamproject._core.error.ex.MyApiException;
import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject._core.util.ApiUtil;
import shop.mtcoding.teamproject.user.User;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private HttpSession session;

    @Transactional
    public void 이력서등록(Resume resume) {
        resumeRepository.save(resume);
    }

    public List<Resume> 이력서목록보기() {
        List<Resume> res = resumeRepository.findAll();
        return res;
    }

    public Resume 이력서상세보기(Integer id) {
        Optional<Resume> resOP = resumeRepository.findById(id);
        if (resOP.isPresent()) {
            return resOP.get();
        } else {
            throw new MyException(id + "는 찾을 수 없습니다");
        }

    }

    @Transactional
    public Resume 이력서수정(Integer id, Resume updatedRes) {
        Optional<Resume> resOP = resumeRepository.findById(id);
        if (resOP.isPresent()) {
            Resume res = resOP.get();
            res.setEducation(updatedRes.getEducation());
            res.setExperience(updatedRes.getExperience());
            res.setHomepage(updatedRes.getHomepage());
            res.setIntroduce(updatedRes.getIntroduce());
            res.setSchool(updatedRes.getSchool());
            res.setSkill(updatedRes.getSkill());
            res.setStatus(updatedRes.isStatus());
            res.setTitle(updatedRes.getTitle());
            return res;
        } else {
            throw new MyException(id + "는 찾을 수 없습니다");
        }

    }

    @Transactional
    public void 이력서삭제(Integer id) {
        try {
            resumeRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException(id + "는 찾을 수 없습니다");
        }
    }

    public User 이력서유저보기(Resume resume) {
        Integer userIndex = resume.getUser().getIndex();
        return resumeRepository.mFindByidJoinResumeInUser(userIndex);

    }

    // 유저가 이력서로 지원할 때 필요
    public List<Resume> 유저의이력서보기(Integer id){
        if (resumeRepository.mFindByUserId(id) == null || resumeRepository.mFindByUserId(id).isEmpty()) {
           throw new MyApiException("제발 ㅠㅠㅠㅠ");
        }else{
            System.out.println("여긴가?");
            return resumeRepository.mFindByUserId(id);
            
        }
    
    }
}
