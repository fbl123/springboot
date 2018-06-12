package com.huijie.demo.controller;

import com.huijie.demo.jpa.UserRepository;
import com.huijie.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @GetMapping("/login")
//    public String login(String name, String password) {
//        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
//
//        } else {
//            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//            Subject subject = SecurityUtils.getSubject();
//            subject.login(token);
//        }
//        return "hello";
//    }

//    @GetMapping("/logout")
//    public String logout(Model model) {
//
//        Subject subject = SecurityUtils.getSubject();
//        System.out.println(subject.getPrincipal());
//        subject.logout();
//        model.addAttribute("message", "成功退出");
//        return "hello";
//    }

    @GetMapping("/error")
    public String error() {

        if (true) {
            throw new RuntimeException();
        }
        return null;
    }


}
