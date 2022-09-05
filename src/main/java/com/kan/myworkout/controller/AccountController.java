package com.kan.myworkout.controller;

import com.kan.myworkout.entity.User;
import com.kan.myworkout.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/register")
    public String registerView() {
        return "account/register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {

        accountRepository.save(user);

        model.addAttribute("message", "회원가입이 완료되었습니다!");
        model.addAttribute("searchUrl", "/account/login");

        return "message";
    }
}
