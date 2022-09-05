package com.kan.myworkout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping
    public String home(HttpSession session) {
        System.out.println("id = " + session.getAttribute("id"));
        System.out.println("userid = " + session.getAttribute("userid"));
        System.out.println("admin = " + session.getAttribute("admin"));
        return "index";
    }
}
