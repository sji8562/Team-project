package shop.mtcoding.teamproject.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findByType(Integer type, Pageable pageable);
    // 타입이 있는 보드를 리스트로 담아서 옴

}
