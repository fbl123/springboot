package com.guns.demo;

import com.guns.demo.jpa.UserRepository;
import com.guns.demo.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        List<SysUser> userList = userRepository.findAll();
        for (SysUser user : userList) {
            System.out.println(user.getAccount());
        }

    }

}
