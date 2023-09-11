package shop.mtcoding.teamproject.apply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.resume.Resume;

public interface ApplyRepository extends JpaRepository<Apply, Integer>{
    @Query("SELECT a.resume FROM Apply a WHERE a.user.index = :id")
    List<Resume> findResumeByUserId(@Param("id") Integer id);

    @Query("SELECT a FROM Apply a JOIN FETCH a.announcement an WHERE a.user.index = :id")
    List<Apply> findAnnByUserId(@Param("id") Integer id);

    
}
    