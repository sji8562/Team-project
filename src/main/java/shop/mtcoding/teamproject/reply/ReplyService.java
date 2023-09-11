package shop.mtcoding.teamproject.reply;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.teamproject._core.error.ex.MyApiException;
import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject.board.Board;
import shop.mtcoding.teamproject.board.BoardRepository;
import shop.mtcoding.teamproject.reply.ReplyRequest.SaveDTO;
import shop.mtcoding.teamproject.user.User;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void 댓글쓰기(SaveDTO saveDTO, Integer sessionId) {
        // insert into reply_tb(comment, board_id, user_id) values(?,?,?)

        Board board = Board.builder().index(saveDTO.getBoardId()).build();

        User user = User.builder().index(sessionId).build();

        Reply reply = Reply.builder() // Reply 객체 구성
                .comment(saveDTO.getComment())
                .board(Board.builder().index(saveDTO.getBoardId()).build())
                .user(User.builder().index(sessionId).build())
                .build();
        replyRepository.save(reply); // entity : Reply 객체
    }

    @Transactional
    public void 댓글삭제(Integer id) {
        List<Reply> replies = replyRepository.findByBoardId(id);
        for (Reply reply : replies) {
            reply.setBoard(null);
            replyRepository.save(reply);
        }
        try {
            boardRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException(id + "를 찾을 수 없어요");
        }
    }

    public List<Reply> 댓글목록보기(Integer id) {
        return replyRepository.findByBoardId(id);

    }

}