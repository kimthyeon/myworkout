package com.kan.myworkout.controller;

import com.kan.myworkout.entity.ShoulderBoard;
import com.kan.myworkout.repository.ShoulderBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shoulderboard")
public class ShoulderBoardController {

    @Autowired
    private ShoulderBoardRepository shoulderBoardRepository;

    @GetMapping("/list")
    public String shoulderHome(@RequestParam(required = false, defaultValue = "") String searchTitle,
                               @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                               Model model) {

        Page<ShoulderBoard> shoulderBoards = shoulderBoardRepository.findByShtitleContaining(searchTitle, pageable);
        int startPage = Math.max(1, shoulderBoards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(shoulderBoards.getTotalPages(), shoulderBoards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute(   "shoulderBoards", shoulderBoards);

        return "shoulderboard/list";

    }

    @GetMapping("/view/{id}")
    public String shoulderView(@PathVariable("id") Integer id,
                               Model model) {

        ShoulderBoard shoulderBoard = shoulderBoardRepository.findById(id).get();
        model.addAttribute("shoulderBoard", shoulderBoard);
        return "shoulderboard/view";
    }

    @GetMapping("/write")
    public String writeView() {
        return "shoulderboard/write";
    }

    @PostMapping("/write")
    public String write(ShoulderBoard shoulderBoard) {
        shoulderBoardRepository.save(shoulderBoard);
        return "redirect:/shoulderboard/list";
    }
}
