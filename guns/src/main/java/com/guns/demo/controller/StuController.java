package com.guns.demo.controller;

import com.guns.demo.common.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StuController {

    @GetMapping("/stu")
    public String test(@RequestParam("stu") Student stu){
        System.out.println(stu);
        return "redirect:/";
    }

}
