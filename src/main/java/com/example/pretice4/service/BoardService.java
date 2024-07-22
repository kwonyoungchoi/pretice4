package com.example.pretice4.service;

import com.example.pretice4.Entity.BoardEntity;
import com.example.pretice4.dto.BoardDTO;
import com.example.pretice4.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;


    public BoardDTO createBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = modelMapper.map(boardDTO, BoardEntity.class);
        BoardEntity saveBoard = boardRepository.save(boardEntity);

        return modelMapper.map(saveBoard, BoardDTO.class);
    }

    public BoardDTO getBoardById(Integer boardId) {
        Optional<BoardEntity> optionalBoard = boardRepository.findById(boardId);

        return modelMapper.map(optionalBoard, BoardDTO.class);
    }

    public BoardDTO updateBoard(BoardDTO updateBoardDTO) {
        Optional<BoardEntity> optionalBoard = boardRepository.findById(updateBoardDTO.getId());

        if (optionalBoard.isPresent()) {
            BoardEntity boardEntity = modelMapper.map(updateBoardDTO, BoardEntity.class);
            boardRepository.save(boardEntity);
            return modelMapper.map(boardEntity, BoardDTO.class);
        }
        return null;
    }

    public List<BoardDTO> getAllBoards() {
        List<BoardEntity> list = boardRepository.findAll();
        return Arrays.asList(modelMapper.map(list, BoardDTO[].class));


    }

    public void deleteBoard(Integer boardId) {
        boardRepository.deleteById(boardId);
    }

}
