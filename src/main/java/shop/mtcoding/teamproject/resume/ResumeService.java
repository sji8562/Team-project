package shop.mtcoding.teamproject.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    
    public void 이력서등록(Resume resume){
        resumeRepository.save(resume);
    }
}
