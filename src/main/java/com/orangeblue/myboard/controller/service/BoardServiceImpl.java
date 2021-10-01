package com.orangeblue.myboard.controller.service;

import java.util.List;
import java.util.Optional;

import com.orangeblue.myboard.domain.Board;
import com.orangeblue.myboard.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> findAll() {
        List<Board> findAllBoards = boardRepository.findAll();
        return findAllBoards;
    }

    @Override
    public Board findById(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        return board;
    }

    @Transactional
    @Override
    public void save(Board board) {
        boardRepository.save(board);
    }

   

    

    
    

}
