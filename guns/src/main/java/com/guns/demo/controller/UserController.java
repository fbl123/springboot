package com.guns.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.jpa.UserReposiory;
import com.guns.demo.manager.UserManager;
import com.guns.demo.mapper.UserMapper;
import com.guns.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/3/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserReposiory userReposiory;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserManager userManager;

    @PostMapping
    public AjaxResult save(User user) {
        return RestTemplate.execute(() -> {
            userManager.save(user);
            return "success";
        });


    }

    @GetMapping
    public AjaxResult list(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        return RestTemplate.execute(() -> {

            PageInfo users=userManager.list(pageNum,pageSize);

            return users;
        });

    }

    @GetMapping("/{id}")
    public AjaxResult user(@PathVariable("id") Long id) {

        return RestTemplate.execute(() -> {

            return userManager.findById(id);
        });
    }


}
