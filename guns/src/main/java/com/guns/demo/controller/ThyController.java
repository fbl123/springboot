package com.guns.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThyController {


    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("message","jick");
        return "hello";
    }
}
