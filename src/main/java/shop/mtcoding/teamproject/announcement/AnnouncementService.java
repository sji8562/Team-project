package shop.mtcoding.teamproject.announcement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Announcement> 공고목록보기(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.ASC, "index");
        return announcementRepository.findAll(pageable);
    }
}
