package shop.mtcoding.teamproject.resume;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.mtcoding.teamproject.user.User;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {
    @Query("SELECT r.user FROM Resume r WHERE r.index = :id")
    User mFindByidJoinResumeInUser(@Param("id") Integer id);

    @Query("SELECT r FROM Resume r WHERE r.user.index = :id")
    List<Resume> mFindByUserId(@Param("id") Integer id);

}
