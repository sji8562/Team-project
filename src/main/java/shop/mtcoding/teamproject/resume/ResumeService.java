package shop.mtcoding.teamproject.resume;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamproject._core.error.ex.MyException;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    
    @Transactional
    public void 이력서등록(Resume resume){
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
            throw new MyException(id+"는 찾을 수 없습니다");
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
            throw new MyException(id+"는 찾을 수 없습니다");
        }
        

    }
    @Transactional
    public void 이력서삭제(Integer id) {
        try {
            resumeRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException(id+"는 찾을 수 없습니다");
        }
    }
}
