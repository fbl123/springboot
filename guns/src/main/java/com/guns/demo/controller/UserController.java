package com.guns.demo.controller;

import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.mapper.SysUserMapper;
import com.guns.demo.model.SysUser;
import com.guns.demo.jpa.UserRepository;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("")
    @ResponseBody
    public String n() {
        return "你好";
    }


    /**
     * 使用RespomseEnitty<T>实现文件下载功能
     *
     * @param
     * @return
     * @throws IOException
     */
    @GetMapping("/respEntity")
    public ResponseEntity<byte[]> file(HttpSession session) throws IOException {
        InputStream inputStream = new FileInputStream("/Users/zl/github/springboot/guns/src/main/java/笔记");
        byte[] body = new byte[inputStream.available()];
        inputStream.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=abc.txt");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
        return responseEntity;
    }


    @PostMapping("/login")
//    @GetMapping("/login")
    public AjaxResult login(String account, String password, HttpSession session) {
        return restTemplate.execute(() -> {
            SysUser user = sysUserMapper.findByAccount(account);
            if (user != null && user.getPassword().equals(password)) { //登录成功
                session.setAttribute("user", user);
            } else {
                throw new RuntimeException("账号或密码错误");
            }
            return "1212";
        });
    }

    @RequestMapping(value = "/greeting")
    public String test(Model model) {

        model.addAttribute("title", "欢迎使用jsp!");
        return "hello";
    }

    @GetMapping("/upload")
    public String up() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
        try {
            file.getOriginalFilename(); //文件名称
            InputStream inputStream = file.getInputStream();//输入流
            long size = file.getSize();
            System.out.println("文件大小为" + size);
            String s = FileUtils.byteCountToDisplaySize(size);//将文件大小转为可读格式
            System.out.println(s);
            IOUtils.copy(inputStream, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "上传成功");
        return "redirect:/user/greeting";
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

    /**
     * 修改信息
     *
     * @param id      用户id
     * @param sysUser 修改后的信息
     * @return
     */
    @PostMapping("/edit/{id:\\d++}")
    public String edit(@PathVariable("id") Integer id, SysUser sysUser) {
        SysUser user = userRepository.getOne(id);
        if (user != null) {
            sysUser.setId(id);
            sysUserMapper.updateByPrimaryKeySelective(user);

        }
        return "";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @PostMapping("/del/{id:\\d++}")
    public String del(@PathVariable("id") Integer id) {
        userRepository.existsById(id);
        return "";
    }
}
