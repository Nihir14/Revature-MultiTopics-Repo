package com.nihir.rev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloGeek {

    @RequestMapping("/spring")
    public String display(Model model) {
        model.addAttribute("message", "Spring MVC Tutorial!!");
        return "index";
    }
}