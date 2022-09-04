package com.kan.myworkout.controller;

import com.kan.myworkout.entity.ChestBoard;
import com.kan.myworkout.entity.FreeBoard;
import com.kan.myworkout.repository.ChestBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/chestboard")
public class ChestBoardController {

    @Autowired
    private ChestBoardRepository chestBoardRepository;

    @GetMapping("/list")
    public String chestHome(@RequestParam(required = false, defaultValue = "") String searchTitle,
                            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                            Model model) {
        Page<ChestBoard> chestBoards = chestBoardRepository.findByChtitleContaining(searchTitle, pageable);
        int startPage = Math.max(1, chestBoards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(chestBoards.getTotalPages(), chestBoards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute(   "chestBoards", chestBoards);

        return "chestboard/list";
    }

    @GetMapping("/view/{id}")
    public String chestView(@PathVariable("id") Integer id, Model model) {
        ChestBoard chestBoard = chestBoardRepository.findById(id).get();
        model.addAttribute("chestBoard", chestBoard);
        return "chestboard/view";
    }

    @GetMapping("/write")
    public String writeView() {
        return "chestboard/write";
    }

    @PostMapping("/write")
    public String write(ChestBoard chestBoard) {
        chestBoardRepository.save(chestBoard);
        return "redirect:/chestboard/list";
    }
}
