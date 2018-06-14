package com.guns.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guns.demo.jpa.UserRepository;
import com.guns.demo.mapper.SysUserMapper;
import com.guns.demo.common.User;
import com.guns.demo.model.SysDept;
import com.guns.demo.model.SysUser;
import com.guns.demo.mq.Producer;
import mystarter.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private User user;
    @Autowired
    private Producer producer;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("#{'${names}'.split('-')}")
    private List<String> names;
    @Autowired
    private MyService myService;

    @Autowired
    private DataSource dataSource;
    @Test
    public void starter(){

       myService.SayHello();
    }


    @Test
    public void contextLoads() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 2, sort);
        Page<SysUser> page = userRepository.findAll(pageable);
        List<SysUser> userList = page.getContent();
        for (SysUser user : userList) {
            System.out.println(user.getAccount());
        }
    }

    @Test
    public void getAll() {
        List<SysUser> userList = userRepository.findAll();
        for (SysUser user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void save() {
        SysUser sysUser = userRepository.findById(2).get();
        sysUser.setAccount("tom");
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
        System.out.println(user);
        System.out.println(names);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        Object o = list;
        if (o instanceof List) {
            System.out.println(o == null);

        }
    }


    @Test
    public void names() {
        List<String> names = sysUserMapper.findName();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void map() {

        Map<String, String> map = user.getMap();
        for (String key : map.keySet()) {
            System.out.println(key + "----->" + map.get(key));
        }


    }

    @Test
    public void mq() throws JMSException {
        int i = 10;
        //        Destination destination = new ActiveMQQueue("mq");
        while (i > 0) {
            producer.send("消息" + i);
            i--;
        }

    }

    @Test
    public void maps() {

        List<Map<String, Object>> maps = sysUserMapper.find();

        System.out.println(maps);

    }
    @Test
    public void query() {
        String name = userRepository.find(1);
        System.out.println(name);

    }
    @Test
    public void dataSource() throws SQLException {
        System.out.println(dataSource.getClass());
    }

}
