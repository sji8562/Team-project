package shop.mtcoding.teamproject.announcement;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Date;
<<<<<<< HEAD

import java.nio.file.*;
import java.util.List;

=======
import java.util.List;
>>>>>>> 308a388930010861fe1a5d2c318575b24b7b4fa1
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject._core.vo.MyPath;
import shop.mtcoding.teamproject.announcement.AnnouncementRequest.UpdateDTO;
import shop.mtcoding.teamproject.skill.Skill;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;

    @Transactional
    public Announcement 공고등록(AnnouncementRequest.SaveDTO saveDTO) {
        // 사진 받는 코드
        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        String fileName = uuid + "_" + saveDTO.getPic().getOriginalFilename();
        Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
        try {
            Files.write(filePath, saveDTO.getPic().getBytes());
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
        // announcement 빌드
        Announcement announcement = Announcement.builder()
                .experience(saveDTO.getExperience())
                .graduation(saveDTO.getGraduation())
                .task(saveDTO.getTask())
                .location(saveDTO.getLocation())
                .endTime(saveDTO.getEndTime())
                .salary(saveDTO.getSalary())
                .preference(saveDTO.getPreference())
                .managerName(saveDTO.getManager())
                .position(saveDTO.getPosition())
                .pic(fileName)
                .workTime(saveDTO.getWorkTime())
                .workDay(saveDTO.getWorkDay())
                .build();
        // 공고 등록
        announcementRepository.save(announcement);

        return announcement;
    }

    @Transactional
    public Announcement 공고수정(Integer id, UpdateDTO updateDTO) {
        Optional<Announcement> annOP = announcementRepository.findById(id);

        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        String fileName = uuid + "_" + updateDTO.getPic().getOriginalFilename();
        Path filePath = Paths.get(MyPath.IMG_PATH + fileName);

        try {
            Files.write(filePath, updateDTO.getPic().getBytes());
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
        System.out.println("++++++++++++++++++++++" + fileName);

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
            ann.setPic(fileName);
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

<<<<<<< HEAD
}
=======
    public List<Announcement> 채용공고(Integer compIdx) {
        System.out.println("===================채용공고 잘돌아감" + compIdx);
        System.out.println(announcementRepository.findByCompIdx(compIdx));
        return announcementRepository.findByCompIdx(compIdx);
    }

}
>>>>>>> 308a388930010861fe1a5d2c318575b24b7b4fa1
