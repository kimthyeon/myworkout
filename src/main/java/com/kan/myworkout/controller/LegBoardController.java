package com.kan.myworkout.controller;

import com.kan.myworkout.entity.BackBoard;
import com.kan.myworkout.entity.LegBoard;
import com.kan.myworkout.repository.LegBoardRepository;
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
@RequestMapping("/legboard")
public class LegBoardController {

    @Autowired
    private LegBoardRepository legBoardRepository;

    @GetMapping("/list")
    public String legHome(Model model,
                           @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String searchTitle) {
        Page<LegBoard> legBoards = legBoardRepository.findByLetitleContaining(searchTitle, pageable);
        int startPage = Math.max(1, legBoards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(legBoards.getTotalPages(), legBoards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("legBoards", legBoards);

        return "legboard/list";

    }

    @GetMapping("/view/{id}")
    public String legView(@PathVariable("id") Integer id, Model model) {
        LegBoard legBoard = legBoardRepository.findById(id).get();
        model.addAttribute("legBoard", legBoard);
        return "legboard/view";
    }

    @GetMapping("/write")
    public String writeView() {
        return "legboard/write";
    }

    @PostMapping("/write")
    public String write(LegBoard legBoard) {
        legBoardRepository.save(legBoard);
        return "redirect:/legboard/list";
    }

}
