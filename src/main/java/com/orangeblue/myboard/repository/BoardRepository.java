package com.orangeblue.myboard.repository;

import com.orangeblue.myboard.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    
    
}
