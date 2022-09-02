package com.kan.myworkout.controller;

import com.kan.myworkout.entity.Notice;
import com.kan.myworkout.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/list")
    public String noticeHome(Model model,
                             @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<Notice> notices = noticeRepository.findByNttitleContaining(searchText, pageable);
        int startPage = Math.max(1, notices.getPageable().getPageNumber() - 4);
        int endPage = Math.min(notices.getTotalPages(), notices.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("notices", notices);

        return "notice/list";
    }

    @GetMapping("/view/{id}")
    public String noticeView(@PathVariable("id") Integer id, Model model) {
        Notice notice = noticeRepository.findById(id).get();
        model.addAttribute("notice", notice);
        return "notice/view";
    }
}
