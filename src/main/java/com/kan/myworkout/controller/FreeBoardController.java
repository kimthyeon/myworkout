package com.kan.myworkout.controller;

import com.kan.myworkout.entity.FreeBoard;
import com.kan.myworkout.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @GetMapping("/list")
    public String noticeHome(Model model,
                             @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<FreeBoard> freeBoards = freeBoardRepository.findByFrtitleContaining(searchText, pageable);
        int startPage = Math.max(1, freeBoards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(freeBoards.getTotalPages(), freeBoards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("freeBoards", freeBoards);

        return "freeboard/list";
    }

    @GetMapping("/view/{id}")
    public String noticeView(@PathVariable("id") Integer id, Model model) {
        FreeBoard freeBoard = freeBoardRepository.findById(id).get();
        model.addAttribute("freeBoard", freeBoard);
        return "freeboard/view";
    }

    @GetMapping("/write")
    public String writeView() {
        return "freeboard/write";
    }

    @PostMapping("/write")
    public String write(FreeBoard freeBoard) {
        freeBoardRepository.save(freeBoard);
        return "redirect:/freeboard/list";
    }

}
