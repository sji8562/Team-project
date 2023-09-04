package shop.mtcoding.teamproject.board;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject.board.BoardRequest.UpdateDTO;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(BoardRequest.SaveDTO saveDTO) {
        Board board = Board.builder()
                .title(saveDTO.getTitle())
                .content(saveDTO.getContent())
                .build();

        boardRepository.save(board);
    }

    @Transactional
    public void 삭제하기(Integer id) {

        boardRepository.deleteById(id);

    }

    public Page<Board> 게시글목록보기(Integer page) {
        // 페이저블이 페이징을 이렇게 하라고 보드 레파지토리로 보냄
        PageRequest pageable = PageRequest.of(page, 3, Sort.Direction.DESC, "index");
        return boardRepository.findAll(pageable);
        // 보드레파지토리에서 페이징을 해서 리턴함
    }

    @Transactional
    public Board 상세보기(Integer id) {

        return boardRepository.findById(id).get();

    }

    @Transactional
    public void 게시글수정하기(Integer id, UpdateDTO updateDTO) {
        Optional<Board> boardOP = boardRepository.findById(id);
        if (boardOP.isPresent()) {
            Board board = boardOP.get();
            board.setTitle(updateDTO.getTitle());
            board.setContent(updateDTO.getContent());
        } else {
            throw new MyException(id + "는 찾을 수 없습니다");
        }
    }
}
// 상세보기 메서드 구현
// findById 리턴값은 옵셔널이니까 예외처리해줌