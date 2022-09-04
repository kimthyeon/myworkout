package com.kan.myworkout.controller;

import com.kan.myworkout.entity.ArmBoard;
import com.kan.myworkout.entity.BackBoard;
import com.kan.myworkout.repository.ArmBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/armboard")
public class ArmBoardController {

    @Autowired
    private ArmBoardRepository armBoardRepository;

    @GetMapping("/list")
    public String armHome(Model model,
                          @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                          @RequestParam(required = false, defaultValue = "") String searchTitle) {
        Page<ArmBoard> armBoards = armBoardRepository.findByArtitleContaining(searchTitle, pageable);
        int startPage = Math.max(1, armBoards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(armBoards.getTotalPages(), armBoards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute(   "armBoards", armBoards);

        return "armboard/list";
    }

    @GetMapping("/view/{id}")
    public String armView(@PathVariable("id") Integer id,
                          Model model) {
        ArmBoard armBoard = armBoardRepository.findById(id).get();
        model.addAttribute("armBoard", armBoard);
        return "armboard/view";
    }

    @GetMapping("/write")
    public String writeView() {
        return "armboard/write";
    }

    @PostMapping("/write")
    public String write(ArmBoard armBoard) {
        armBoardRepository.save(armBoard);
        return "redirect:/armboard/list";
    }
}
