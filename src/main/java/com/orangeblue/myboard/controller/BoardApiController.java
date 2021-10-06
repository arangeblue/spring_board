package com.orangeblue.myboard.controller;

import java.util.List;

import com.orangeblue.myboard.domain.Board;
import com.orangeblue.myboard.service.BoardService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {
    
    private final BoardService boardService;


    @GetMapping("/boards")
    public List<Board> findByTitleOrAll(@RequestParam(value = "title", required = false) String title) {
        List<Board> findBoards = boardService.findByTitle(title);
        return findBoards;
    }

    @PostMapping("/boards")
    public Board save(@RequestBody Board board) {
        return boardService.saveApi(board);
    }

    @PutMapping("/boards/{id}")
    public Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {
        return boardService.update(newBoard, id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/boards/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
    }

}
