package com.kan.myworkout.controller;

import com.kan.myworkout.entity.Notice;
import com.kan.myworkout.entity.User;
import com.kan.myworkout.repository.AccountRepository;
import com.kan.myworkout.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String registerView() {
        return "account/register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {

        accountRepository.save(user);
        user.setAdmin(0);

        model.addAttribute("message", "회원가입이 완료되었습니다!");
        model.addAttribute("searchUrl", "/account/login");

        return "message";
    }

    @GetMapping("/login")
    public String loginView() {
        return "account/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String, String> param, HttpSession session) {
        int loginResult = accountService.login(param);
        if (loginResult == 1) {
            session.setAttribute("id", accountService.getId(param));
            session.setAttribute("admin", accountService.adMin(param.get("userid")));
            session.setAttribute("userid", param.get("userid"));

            return "redirect:/";
        }else {
            return "redirect:/account/login"; // 로그인 실패 메세지
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/list")
    public String userList(Model model,
                             @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam(required = false, defaultValue = "") String searchName) {
        Page<User> users = accountRepository.findByUsernameContaining(searchName, pageable);
        int startPage = Math.max(1, users.getPageable().getPageNumber() - 4);
        int endPage = Math.min(users.getTotalPages(), users.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("users", users);

        return "account/list";
    }

    @GetMapping("/view/{id}")
    public String userView(@PathVariable("id") Integer id, Model model) {
        User user = accountRepository.findById(id).get();
        model.addAttribute("user", user);
        return "account/view";
    }
}
