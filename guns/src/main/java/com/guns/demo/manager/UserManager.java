package com.guns.demo.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.guns.demo.jpa.UserRepository;
import com.guns.demo.mapper.UserMapper;
import com.guns.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/3/12.
 */
@Service
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public PageInfo list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(userMapper.get());

    }

    public Object findById(Long id) {

                 /*
              * 当使用getOne()时作为响应时
              *由于jackson获取不到代理对象所以会抛出
              *com.fasterxml.jackson.databind.exc.InvalidDefinitionException
              * 建议使用findById();
              */
/*
            User user=userRepository.getOne(id);
            user.getId();
            return user;
*/

        return userRepository.findById(id);
    }

    public void deleteById(Long id) {

        userMapper.deleteById(id);
//        userRepository.deleteById(id);
    }
}
