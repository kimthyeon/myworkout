package com.kan.myworkout.controller;

import com.kan.myworkout.entity.StreetBoard;
import com.kan.myworkout.repository.StreetBoardRepository;
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
@RequestMapping("/streetboard")
public class StreetBoardController {

    @Autowired
    private StreetBoardRepository streetBoardRepository;

    @GetMapping("/list")
    public String streetHome(@RequestParam(required = false, defaultValue = "") String searchTitle,
                             @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                             Model model) {

        Page<StreetBoard> streetBoards = streetBoardRepository.findBySttitleContaining(searchTitle, pageable);
        int startPage = Math.max(1, streetBoards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(streetBoards.getTotalPages(), streetBoards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("streetBoards", streetBoards);
        return "streetboard/list";
    }

    @GetMapping("/view/{id}")
    public String streetView(@PathVariable("id") Integer id, Model model) {
        StreetBoard streetBoard = streetBoardRepository.findById(id).get();
        model.addAttribute("streetBoard", streetBoard);
        return "streetboard/view";
    }

    @GetMapping("/write")
    public String writeView() {
        return "streetboard/write";
    }

    @PostMapping("/write")
    public String write(StreetBoard streetBoard) {
        streetBoardRepository.save(streetBoard);
        return "redirect:/streetboard/list";
    }
}
