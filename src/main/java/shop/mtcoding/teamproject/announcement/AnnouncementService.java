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
    
    @Transactional
    public void 공고등록(Announcement announcement){
        announcementRepository.save(announcement);
    }

    public Announcement 공고상세보기(Integer id) {
        Optional<Announcement> annOP = announcementRepository.findById(id);
        return annOP.get();
    }

    public Page<Announcement> 공고목록보기(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.ASC, "index");
        //이 페이지 객체가 다른 메소드에서도 필요해서 이렇게 따로 객체 선언해줌
        Page<Announcement> pageContent = announcementRepository.findAll(pageable);
        return pageContent;
    }

    
    
}
