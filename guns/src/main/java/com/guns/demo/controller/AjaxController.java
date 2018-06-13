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
     * @return
     */
    @GetMapping("/user/list")
    public AjaxResult userlist() {

        return RestTemplate.execute(() -> {
            return userRepository.findAll();
        });

    }

    @ModelAttribute
    public void user(@RequestParam("id") Integer id,Map<String,Object> map){
        SysUser sysUser=new SysUser();
        sysUser.setId(id);
        sysUser.setAccount("hh");
        map.put("sysUser",sysUser);

    }
    @GetMapping("/user")
    public void user(SysUser sysUser){
        System.out.println(sysUser);
    }



    @GetMapping("/test")
    public String test(){
        return "get";
    }
    @PostMapping("/test")
    public String test2(){
        return "post";
    }
    @DeleteMapping("/test")
    public String test3(){
        return "delete";
    }
    @PutMapping("/test")
    public String test4(){
        return "put";
    }

    public static void main(String[] args) {
        String text="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<PostResponse xmlns=\"http://s3.amazonaws.com/doc/2006-03-01/\">\n" +
                "    <Bucket>pku.digital-cdn.com</Bucket>\n" +
                "    <Key>d/1.png</Key>\n" +
                "    <Location>http://pku.digital-cdn.com.nos.wjv-1.neo.id:80/d%2F1.png</Location>\n" +
                "    <ETag>&quot;b409f04cb2b62219316673e9f0da80cf&quot;</ETag>\n" +
                "</PostResponse>";


//    X-Amz-Date:20180530T103653Z
        System.out.println(new Date());

        System.out.println("1.pdfdone".endsWith("pdf"));

        try {
            Document doc=DocumentHelper.parseText(text);
            Element root=doc.getRootElement();
            System.out.println(root.getName());
            Element location = root.element("Location");
            System.out.println(location.getText());


        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}
