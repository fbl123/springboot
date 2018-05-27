package com.guns.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guns.demo.jpa.UserRepository;
import com.guns.demo.mapper.SysUserMapper;
import com.guns.demo.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    UserRepository userRepository;
    @Autowired
    SysUserMapper sysUserMapper;
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
    public void save() {
        SysUser sysUser = userRepository.findById(2).get();
        sysUser.setAccount("jick");
        sysUser.setPassword("000000");
        userRepository.save(sysUser);
    }


    @Test
    public void redisTest() {
        redisTemplate.opsForValue().set("name", "jick");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void page() {
        PageHelper.startPage(1, 2);
        List<SysUser> userList = sysUserMapper.findAll();
        PageInfo<SysUser> page = new PageInfo<>(userList);
        for (SysUser user : page.getList()) {
            System.out.println(user);

        }

    }


}
