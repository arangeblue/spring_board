package com.orangeblue.myboard.controller;

import javax.validation.Valid;

import com.orangeblue.myboard.domain.Board;
import com.orangeblue.myboard.service.BoardService;
import com.orangeblue.myboard.validator.BoardValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String boardList(Model model, @RequestParam(defaultValue = "", required = false) String searchText, @PageableDefault(size = 2) Pageable pageable) {

        // Page<Board> boards = boardService.findAll(pageable);
        Page<Board> boards = boardService.searchByTitleOrContent(searchText, searchText, pageable);
        
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        int currentPageNumber = boards.getPageable().getPageNumber();
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
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
