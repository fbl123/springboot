package com.guns.demo.mapper;

import com.guns.demo.model.SysDict;

public interface SysDictMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(SysDict record);


    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDict record);


    int updateByPrimaryKey(SysDict record);
}