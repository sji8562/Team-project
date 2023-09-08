package shop.mtcoding.teamproject.userscrap;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserScrapRepository extends JpaRepository<UserScrap, Integer> {

    UserScrap findByAnnIdxAndUserIdx(Integer annIdx, Integer userIdx);

}
