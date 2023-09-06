package shop.mtcoding.teamproject.smalljob;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SmallJobRepository extends JpaRepository<SmallJob, Integer> {

    @Query("SELECT s, s.bigJob.bigName FROM SmallJob s")
    List<Object[]> findAllWithBigJob();

}
