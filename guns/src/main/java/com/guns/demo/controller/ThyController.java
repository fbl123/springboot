package com.guns.demo.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.guns.demo.model.SysUser;
import com.guns.demo.jpa.UserRepository;
import com.guns.demo.mq.Producer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ThyController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Producer producer;
    @GetMapping("/")
    public String hello(Model model) {
        SysUser user = userRepository.findById(1).get();
        model.addAttribute("user", user);
        return "hello";
    }

    @GetMapping("/message")
    @ResponseBody
    public SysUser sendMessage(SysUser user){
        String json=JSON.toJSONString(user);
        producer.send(JSON.toJSONString(user));
        return user;
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
