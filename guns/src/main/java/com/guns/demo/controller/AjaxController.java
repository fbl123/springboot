package com.guns.demo.controller;

import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.model.SysUser;
import com.guns.demo.jpa.UserRepository;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * ajax
 * 返回json数据的请求 放这里
 */
@RestController
@RequestMapping("/api")
public class AjaxController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    public AjaxResult get() {
        return RestTemplate.execute(() -> {
            System.out.println("hh");
            return null;
        });
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("/user/list")
    public AjaxResult userlist() {

        return RestTemplate.execute(() -> {
            return userRepository.findAll();
        });

    }

    @ModelAttribute
    public void user(@RequestParam("id") Integer id, Map<String, Object> map) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setAccount("hh");
        map.put("sysUser", sysUser);

    }


    @GetMapping("/user")
    public void user(SysUser sysUser) {
        System.out.println(sysUser);
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

