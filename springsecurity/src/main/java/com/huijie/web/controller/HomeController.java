package com.huijie.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {


    @GetMapping("/login")
    public String login(){
        return "login";

    }
    @PostMapping("/login")
    @ResponseBody
    public Object login(String username,String password){
        Map<String,String> map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);

        return map;
    }


}
