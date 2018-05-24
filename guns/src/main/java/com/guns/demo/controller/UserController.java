package com.guns.demo.controller;

import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.mapper.SysUserMapper;
import com.guns.demo.model.SysUser;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("")
    @ResponseBody
    public String n(){
        return "你好";
    }


//    @PostMapping("/login")
    @GetMapping("/login")
    public AjaxResult login(String account,String password,HttpSession session) {
        return restTemplate.execute(() -> {
            SysUser user = sysUserMapper.findByAccount(account);
            if(user!=null&&user.getPassword().equals(password)){ //登录成功
                session.setAttribute("user",user);
            }else{
                System.out.println("账号或密码错误");
                throw new RuntimeException("账号或密码错误");
            }
            return "1212";
        });
    }
    @RequestMapping(value = "/greeting")
    public String test(Model model) {

        model.addAttribute("title","欢迎使用jsp!");
        return "hello";
    }

    @GetMapping("/upload")
    public String up(){
        return "hello";
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file){
        try {
            file.getOriginalFilename(); //文件名称
            InputStream inputStream = file.getInputStream();//输入流
            file.getSize();
            IOUtils.copy(inputStream,System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
