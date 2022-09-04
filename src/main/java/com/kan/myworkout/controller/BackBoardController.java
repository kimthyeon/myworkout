package com.kan.myworkout.controller;

import com.kan.myworkout.entity.BackBoard;
import com.kan.myworkout.entity.ChestBoard;
import com.kan.myworkout.repository.BackBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/backboard")
public class BackBoardController {

    @Autowired
    private BackBoardRepository backBoardRepository;

    @GetMapping("/list")
    public String backHome(@RequestParam(required = false, defaultValue = "") String searchTitle,
                            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                            Model model) {
        Page<BackBoard> backBoards = backBoardRepository.findByBatitleContaining(searchTitle, pageable);
        int startPage = Math.max(1, backBoards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(backBoards.getTotalPages(), backBoards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute(   "backBoards", backBoards);

        return "backboard/list";
    }

    @GetMapping("/view/{id}")
    public String backView(@PathVariable("id") Integer id, Model model) {
        BackBoard backBoard = backBoardRepository.findById(id).get();
        model.addAttribute("backBoard", backBoard);
        return "backboard/view";
    }

    @GetMapping("/write")
    public String writeView() {
        return "backboard/write";
    }

    @PostMapping("/write")
    public String write(BackBoard backBoard) {
        backBoardRepository.save(backBoard);
        return "redirect:/backboard/list";
    }
}
