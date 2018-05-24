package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {



    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("title","springboot");
       return "hello";
    }


    @PostMapping()
    public Object login(@RequestParam("userName") String userName,
                        @RequestParam("password") String psw){
        if("admin".equals(userName)&&"admin".equals(psw)){
            return "";
        }

        return null;
    }



}
