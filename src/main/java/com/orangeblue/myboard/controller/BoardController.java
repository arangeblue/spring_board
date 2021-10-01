package com.orangeblue.myboard.controller;

import java.util.List;

import javax.validation.Valid;

import com.orangeblue.myboard.controller.service.BoardService;
import com.orangeblue.myboard.domain.Board;
import com.orangeblue.myboard.repository.BoardRepository;
import com.orangeblue.myboard.validator.BoardValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {
    
    
    private final BoardService boardService;
    
    @Autowired
    private BoardValidator boardValidator;

    @GetMapping("/list")
    public String boardList(Model model) {

        List<Board> boards = boardService.findAll();

        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/write")
    public String writeForm(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {

            model.addAttribute("board", new Board());
        
        } else {
            Board board = boardService.findById(id);
            model.addAttribute("board", board);
        }
        
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String writeFormSubmit(@Valid Board board, BindingResult bindingResult) {

        boardValidator.validate(board, bindingResult);

        if (bindingResult.hasErrors()) {
            return "board/writeForm";
        }

        boardService.save(board);
        return "redirect:/board/list";
    }
}
