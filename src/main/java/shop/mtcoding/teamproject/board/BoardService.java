package shop.mtcoding.teamproject.board;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.board.BoardRequest.UpdateDTO;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(BoardRequest.SaveDTO saveDTO) {
        Board board = null;
        if (saveDTO.getUserIdx() != null && !saveDTO.getUserIdx().equals("")) {
            board = Board.builder()
                    .title(saveDTO.getTitle())
                    .content(saveDTO.getContent())
                    .userIdx(saveDTO.getUserIdx())
                    .type(2)
                    .build();
        } else {
            board = Board.builder()
                    .title(saveDTO.getTitle())
                    .content(saveDTO.getContent())
                    .compIdx(saveDTO.getCompIdx())
                    .type(2)
                    .build();
        }

        boardRepository.save(board);
    }

    @Transactional
    public void 삭제하기(Integer id) {
        boardRepository.deleteById(id);
    }

    public Page<Board> 문의목록보기(Integer page) {
        // // 페이저블이 페이징을 이렇게 하라고 보드 레파지토리로 보냄
        Pageable pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "index");
        Page<Board> pageContentQna = boardRepository.findByType(1, pageable);
        return pageContentQna;

        // // 보드레파지토리에서 페이징을 해서 리턴함
    }

    public Page<Board> 도움말목록보기(Integer page) {
        // // 페이저블이 페이징을 이렇게 하라고 보드 레파지토리로 보냄
        Pageable pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "index");
        Page<Board> pageContentHelp = boardRepository.findByType(2, pageable);
        return pageContentHelp;

        // // 보드레파지토리에서 페이징을 해서 리턴함
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