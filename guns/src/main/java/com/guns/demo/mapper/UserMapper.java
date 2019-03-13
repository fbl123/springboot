package com.guns.demo.mapper;

import com.guns.demo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/3/10.
 */
public interface UserMapper {


    List<User> get();

    void deleteById(@Param("id") Long id);

    void update(User user);
}
