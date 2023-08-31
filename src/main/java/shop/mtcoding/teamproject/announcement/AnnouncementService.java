package shop.mtcoding.teamproject.announcement;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;

    public void 공고등록(Announcement announcement){
        announcementRepository.save(announcement);
    }
    
    @Transactional
    public void 공고수정(Announcement announcement){
        
    }

    public Announcement 공고상세보기(Integer id) {
        Optional<Announcement> annOP = announcementRepository.findById(id);
        return annOP.get();
    }
}
