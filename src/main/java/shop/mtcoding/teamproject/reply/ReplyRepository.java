package shop.mtcoding.teamproject.reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Query("select r from Reply r where r.board.index = :boardIndex")
    List<Reply> findByBoardId(@Param("boardIndex") Integer boardIndex);
}
