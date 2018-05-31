package com.guns.demo.controller;

import com.guns.demo.jpa.UserRepository;
import com.guns.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThyController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String hello(Model model) {
        SysUser user = userRepository.findById(1).get();
        model.addAttribute("user", user);
        return "hello";
    }

    @GetMapping("/error")
    public String error() {

        if (true) {
            throw new RuntimeException();
        }
        return null;
    }


}
