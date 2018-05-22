package com.guns.demo.controller;

import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.mapper.SysUserMapper;
import com.guns.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    RestTemplate restTemplate;

//    @PostMapping("/login")
    @GetMapping("/login")
    @ResponseBody
    public AjaxResult login(String account,String password,HttpSession session) {
        return restTemplate.execute(() -> {
            SysUser user = sysUserMapper.findByAccount(account);
            if(user!=null&&user.getPassword().equals(password)){ //登录成功
                session.setAttribute("user",user);
            }else{
                throw new RuntimeException("账号或密码错误");
            }

           return null;
        });
    }


    /**
     * 注册
     *
     * @return
     */
    @PostMapping("/registered")
    @ResponseBody
    public AjaxResult registered(SysUser user) {
        return restTemplate.execute(() -> {
            SysUser sysUser = sysUserMapper.findByAccount(user.getAccount());
            if (sysUser != null) {
                throw new RuntimeException("该用户已存在");
            } else {
                sysUserMapper.insertSelective(user);
            }
            return null;
        });

    }


}
