package com.project.Quan_li_cafe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "home"; // tên của template (home.html)
    }
}
