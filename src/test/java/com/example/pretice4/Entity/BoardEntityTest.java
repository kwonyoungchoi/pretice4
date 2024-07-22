package com.example.pretice4.Entity;

import com.example.pretice4.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardEntityTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void BoardInsertTest() {
        for (int i = 0; i < 10; i++) {
            //데이터 값 준비
            BoardEntity boardEntity = BoardEntity.builder()
                    .subject("게시물 제목" + i)
                    .content("게시물 내용" + i)
                    .build();
            System.out.println(boardRepository.save(boardEntity));
        }
    }

    @Test
    public void BoardUpdateTest() {
        //데이터값 준비(Entity)
        BoardEntity boardEntity = BoardEntity.builder()
                .id(1)
                .subject("제목 수정")
                .content("내용 수정")
                .build();
        System.out.println(boardRepository.save(boardEntity));
    }

    @Test
    public void BoardListTest() {
        List<BoardEntity> list = boardRepository.findAll();
        System.out.println(list);
    }

    @Test
    public void listOneTest() {
        Optional<BoardEntity> list = boardRepository.findById(1);
        System.out.println(list);
    }

    @Test
    public void deleteTest() {
        boardRepository.deleteById(1);
    }
}