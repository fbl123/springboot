package com.guns.demo.controller;

import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.jpa.DeptRepository;
import com.guns.demo.jpa.UserRepository;
import com.guns.demo.mapper.SysUserMapper;
import com.guns.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ajax
 * 返回json数据的请求 放这里
 */
@RestController
@RequestMapping("/api")
public class AjaxController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DeptRepository deptRepository;

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

    /**
     * 获取所有部门
     *
     * @return
     */
    @GetMapping
    public AjaxResult depts() {
        return RestTemplate.execute(() -> {
            return deptRepository.findAll();
        });
    }


}
