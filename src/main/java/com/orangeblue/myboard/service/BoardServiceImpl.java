package com.orangeblue.myboard.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.orangeblue.myboard.domain.Board;
import com.orangeblue.myboard.repository.BoardRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Page<Board> findAll(Pageable pageable) {
        Page<Board> findAllBoards = boardRepository.findAll(pageable);
        return findAllBoards;
    }

    @Override
    public Board findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        return board;
    }

    @Transactional
    @Override
    public Board save(Board board) {

        return boardRepository.save(board);
    }

    @Override
    public List<Board> findByTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            return boardRepository.findAll();
        } else {
            return boardRepository.findByTitle(title);
        }
        
    }

    @Override
    public Board update(Board newBoard, Long id) {
        Board findBoard = boardRepository.findById(id).orElseThrow(() -> new  NoSuchElementException());

        findBoard.setWriter(newBoard.getWriter());
        findBoard.setTitle(newBoard.getTitle());
        findBoard.setContent(newBoard.getContent());

        return boardRepository.save(findBoard);
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Page<Board> searchByTitleOrContent(String title, String content, Pageable pageable) {
        
        Page<Board> searchByTitleOrContent = boardRepository.findByTitleContainingOrContentContaining(title, content, pageable);
        

        
        return searchByTitleOrContent;
    }

   

    

    
    

}
