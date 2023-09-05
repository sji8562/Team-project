package shop.mtcoding.teamproject.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.mtcoding.teamproject.reply.Reply;
import shop.mtcoding.teamproject.reply.ReplyService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/comunitydetail")
    public String comunitydetail() {
        return "comunity/comunityDetail";
    }

    @GetMapping("/comunitywrite")
    public String comunitywrite() {
        return "comunity/comunityWrite";
    }

    @PostMapping("/comunity/save")
    public void save(BoardRequest.SaveDTO saveDTO, HttpServletResponse response) throws IOException {
        boardService.글쓰기(saveDTO);
        response.sendRedirect("/comunity");
        // return "redirect:/comunity/comunityDetail";
    }

    @PostMapping("/comunity/{id}/delete")
    public String delete(@PathVariable Integer id) {
        boardService.삭제하기(id);
        return "redirect:/comunity";
    }

    @GetMapping("/comunity")
    public String boardIndex(@RequestParam(defaultValue = "0") Integer page, HttpServletRequest request) {

        Page<Board> boardHelp = boardService.도움말목록보기(page);
        Page<Board> boardQna = boardService.문의목록보기(page);
        request.setAttribute("boardHelp", boardHelp.getContent());
        request.setAttribute("boardQna", boardQna.getContent());
        // request.setAttribute("prevPage", boardPG.getNumber() - 1);
        // request.setAttribute("nextPage", boardPG.getNumber() + 1);

        return "comunity/comunityList";

    }

    @GetMapping("/comunity/comunitydetail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        List<Reply> replies = replyService.댓글목록보기(id);
        model.addAttribute("replies", replies);
        model.addAttribute("board", boardService.상세보기(id));

        return "comunity/comunityDetail";
    }

}