package com.orangeblue.myboard.repository;

import java.util.List;

import com.orangeblue.myboard.domain.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    
    List<Board> findByTitle(String title);
    
    Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

}
