package com.guns.demo.controller;

import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;

import org.springframework.web.bind.annotation.*;



/**
 * ajax
 * 返回json数据的请求 放这里
 */
@RestController
@RequestMapping("/api")
public class AjaxController {


    @GetMapping("")
    public AjaxResult get() {
        return RestTemplate.execute(() -> {
            System.out.println("hh");
            return null;
        });
    }








    @GetMapping("/test")
    public String test() {
        return "get";
    }

    @PostMapping("/test")
    public String test2() {
        return "post";
    }

    @DeleteMapping("/test")
    public String test3() {
        return "delete";
    }

    @PutMapping("/test")
    public String test4() {
        return "put";
    }
}

