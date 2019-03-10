package com.guns.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.jpa.UserReposiory;
import com.guns.demo.mapper.UserMapper;
import com.guns.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public AjaxResult save(User user) {
        return RestTemplate.execute(() -> {
            userReposiory.save(user);

            return AjaxResult.ok("添加成功");
        });


    }

    @GetMapping
    public AjaxResult list(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(name ="pageSize",defaultValue = "10")Integer pageSize){

        return RestTemplate.execute(()->{
            PageHelper.startPage(1,10);
            List<User> userList=userMapper.get();

            return AjaxResult.ok(new PageInfo<>(userList));
        });

    }


}
