package com.huijie.oa;

import com.huijie.oa.dao.jpa.UserRepository;
import com.huijie.oa.entity.User;
import org.apache.shiro.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Test
    public void contextLoads() {
//       User user = userRepository.findById(1L).get();
        User user=new User();
        user.setName("tom");
        userRepository.save(user);
        System.out.println(user.getId());

    }

}
