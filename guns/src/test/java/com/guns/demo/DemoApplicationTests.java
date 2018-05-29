package com.guns.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guns.demo.jpa.DeptRepository;
import com.guns.demo.jpa.UserRepository;
import com.guns.demo.mapper.SysUserMapper;
import com.guns.demo.model.SysDept;
import com.guns.demo.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;
import sun.jvm.hotspot.debugger.Page;
import sun.security.provider.MD5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private DeptRepository deptRepository;
    @Value("#{'${name}'.substring(2)}")
    private String value;

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

    @Test
    public void value() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        Object o = list;
        if (o instanceof List) {
            System.out.println(o == null);

        }
    }

    @Test
    public void deptList() {
        List<SysDept> deptList = deptRepository.findAll();
        for (SysDept dept : deptList) {
            System.out.println(dept);
        }
    }
}
