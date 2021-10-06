package com.orangeblue.myboard.service;

import java.util.List;

import com.orangeblue.myboard.domain.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    

    public Page<Board> findAll(Pageable pageable);

    public Board findById(Long id);

    public List<Board> findByTitle(String title);

    public Page<Board> searchByTitleOrContent(String title, String content, Pageable pageable);

    public Board saveApi(Board board);

    public Board saveBoard(Board board, String username);

    public Board update(Board board, Long id);

    public void delete(Long id);

}
