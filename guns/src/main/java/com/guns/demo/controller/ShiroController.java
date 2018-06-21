//package com.guns.demo.controller;
//
//
//import com.guns.demo.common.User;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class ShiroController {
//
//    @GetMapping("/shiro")
//    public Object shiroTest() {
//        Subject subject = SecurityUtils.getSubject();
//
//        if (subject.isAuthenticated()) {
//            User user = (User) subject.getPrincipal();
//            System.out.println(user);
//            return user;
//        }
//        String name = "admin";
//        String password = "000000";
//        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//        subject.login(token);
//        return "login";
//
//    }
//
//
//}
