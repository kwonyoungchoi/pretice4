package com.example.pretice4.controller;

import com.example.pretice4.dto.BoardDTO;
import com.example.pretice4.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index() {
        log.info("목록 페이지로 이동...");

        return "redirect:/getAll";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        log.info("등록 페이지로 이동...");

        model.addAttribute("boardDTO", new BoardDTO());

        return "boardInsert";
    }

    @PostMapping("/create")
    public String createBoard(@ModelAttribute BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        log.info("등록 처리 후 목록페이지로 이동...");

        boardService.createBoard(boardDTO);
        redirectAttributes.addFlashAttribute("successMessage", "저장하였습니다.");
        return "redirect:/getAll";
    }

    @GetMapping("/getAll")
    public String getAllBoards(Model model) {
        log.info("데이터 조회 후 목록페이지로 이동...");

        List<BoardDTO> allBoards = boardService.getAllBoards();

        model.addAttribute("boardList", allBoards);
        return "boardList";
    }

    @GetMapping("/{boardId}")
    public String getBoardById(@PathVariable Integer boardId, Model model) {
        log.info("데이터 조회 후 목록페이지로 이동...");

        BoardDTO boardDTO = boardService.getBoardById(boardId);

        model.addAttribute("boardDTO", boardDTO);
        return "boardDetail";

    }

    @GetMapping("/update/{boardId}")
    public String updateForm(@PathVariable Integer boardId, Model model) {
        log.info("데이터 조회 후 수정페이지로 이동...");

        BoardDTO boardDTO = boardService.getBoardById(boardId);

        model.addAttribute("boardDTO", boardDTO);
        return "boardUpdate";
    }

    @PostMapping("/update")
    public String updateBoard(@ModelAttribute BoardDTO updateBoardDTO, RedirectAttributes redirectAttributes) {
        log.info("수정 처리 후 목록페이지로 이동...");

        boardService.updateBoard(updateBoardDTO);

        redirectAttributes.addFlashAttribute("successMessage", "수정하였습니다.");
        return "redirect:/getAll";
    }

    @GetMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable Integer boardId, RedirectAttributes redirectAttributes) {
        boardService.deleteBoard(boardId);
        redirectAttributes.addFlashAttribute("successMessage", "삭제하였습니다");

        return "redirect:/getAll";
    }
}
