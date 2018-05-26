package com.guns.demo;

import com.guns.demo.jpa.UserRepository;
import com.guns.demo.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    UserRepository userRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        List<SysUser> userList = userRepository.findAll();
        for (SysUser user : userList) {
            System.out.println(user.getAccount());
        }

    }
    @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("name","jick");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }




}
