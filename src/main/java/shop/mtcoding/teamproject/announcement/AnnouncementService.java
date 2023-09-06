package shop.mtcoding.teamproject.announcement;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject.announcement.AnnouncementRequest.UpdateDTO;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;

    @Transactional
    public void 공고등록(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    @Transactional
    public Announcement 공고수정(Integer id, UpdateDTO updateDTO) {
        Optional<Announcement> annOP = announcementRepository.findById(id);
        if (annOP.isPresent()) {
            Announcement ann = annOP.get();
            ann.setWorkType(updateDTO.getWorkType());
            ann.setExperience(updateDTO.getExperience());
            ann.setGraduation(updateDTO.getGraduation());
            ann.setTask(updateDTO.getTask());
            ann.setLocation(updateDTO.getLocation());
            ann.setStartTime(updateDTO.getStartTime());
            ann.setEndTime(updateDTO.getEndTime());
            ann.setSalary(updateDTO.getSalary());
            ann.setPreference(updateDTO.getPreference());
            ann.setManagerName(updateDTO.getManager());
            ann.setPosition(updateDTO.getPosition());
            ann.setPic(updateDTO.getPic());
            ann.setWorkTime(updateDTO.getWorkTime());
            ann.setWorkDay(updateDTO.getWorkDay());
            return ann;
        } else {
            throw new MyException(id + "를 찾을 수 없습니다");
        }

    }

    public Announcement 공고상세보기(Integer id) {
        Optional<Announcement> annOP = announcementRepository.findById(id);
        if (annOP.isPresent()) {
            return annOP.get();
        } else {
            throw new MyException(id + "는 찾을 수 없습니다");
        }

    }

    public Page<Announcement> 공고목록보기(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.ASC, "index");
        Page<Announcement> pageContent = announcementRepository.findAll(pageable);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Format the updateTime to display only the date
        pageContent.forEach(announcement -> {
            Timestamp timestamp = announcement.getUpdateTime();
            Date date = new Date(timestamp.getTime());
            String formattedDate = dateFormat.format(date);
            announcement.setUpdateTime(Timestamp.valueOf(formattedDate + " 00:00:00"));
        });

        return pageContent;
    }

    public Page<Announcement> index공고목록보기(Integer page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, "index");
        Page<Announcement> pageContent = announcementRepository.findAll(pageable);
        return pageContent;
    }

    @Transactional
    public void 공고삭제(Integer id) {

        try {
            announcementRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException(id + "를 찾을 수 없습니다");
        }
    }

}
