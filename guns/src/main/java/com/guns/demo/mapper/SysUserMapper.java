package com.guns.demo.mapper;

import com.guns.demo.model.SysUser;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface SysUserMapper  {

    int deleteByPrimaryKey(Integer id);


    int insert(SysUser record);


    int insertSelective(SysUser record);



    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);


    int updateByPrimaryKey(SysUser record);

    SysUser findByAccount(@Param("account") String account);

    List<SysUser> findAll();

    @Select("select name from sys_user")
    @Results({
            @Result(property = "name",column = "name")
    })
    List<String> findName();

    @Select("select name,account from sys_user")
    List<Map<String,Object>> find();

    Map<String,Object> get();

}