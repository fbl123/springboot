package com.guns.demo.mapper;

import com.guns.demo.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(SysUser record);


    int insertSelective(SysUser record);



    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);


    int updateByPrimaryKey(SysUser record);

    SysUser findByAccount(@Param("account") String account);

    List<SysUser> findAll();

}