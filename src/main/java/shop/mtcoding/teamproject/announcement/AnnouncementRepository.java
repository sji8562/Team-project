package shop.mtcoding.teamproject.announcement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    @Query("SELECT a FROM Announcement a WHERE a.company_id = :compIdx")
    List<Announcement> findByCompIdx(@Param("compIdx") Integer compIdx);
}
