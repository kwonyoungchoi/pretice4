package com.example.pretice4.service;

import com.example.pretice4.dto.BoardDTO;
import com.example.pretice4.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void BoardInsertTest() {
        BoardDTO boardDTO = BoardDTO.builder()
                .subject("게시물 제목")
                .content("게시물 내용")
                .build();
        System.out.println(boardService.createBoard(boardDTO));
    }

    @Test
    public void BoardUpdateTest() {
        BoardDTO boardDTO = BoardDTO.builder()
                .id(1)
                .subject("제목 수정")
                .content("내용 수정")
                .build();
        System.out.println(boardService.updateBoard(boardDTO));
    }

    @Test
    public void BoardListTest() {
        List<BoardDTO> allBoards = boardService.getAllBoards();
        System.out.println(allBoards);
    }

    @Test
    public void listOneTest() {
        BoardDTO data = boardService.getBoardById(1);
        System.out.println(data);
    }

    @Test
    public void deleteTest() {
        boardService.deleteBoard(1);
    }

}