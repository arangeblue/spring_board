package com.orangeblue.myboard.controller.service;

import java.util.List;
import java.util.Optional;

import com.orangeblue.myboard.domain.Board;

public interface BoardService {
    

    public List<Board> findAll();

    public Board findById(Long id);

    public void save(Board board);

}
