package shop.mtcoding.teamproject.resume;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    
    public void 이력서등록(Resume resume){
        resumeRepository.save(resume);
    }

    public List<Resume> 이력서목록보기() {
        List<Resume> res = resumeRepository.findAll();
        return res;
    }

    public Resume 이력서등록() {
        return null;
    }

    public Resume 이력서상세보기(Integer id) {
        Resume res = resumeRepository.findById(id).get();
        return res;
    }
}
