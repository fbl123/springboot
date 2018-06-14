package com.guns.demo.mapper;

import com.guns.demo.model.SysExpense;

public interface SysExpenseMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(SysExpense record);


    int insertSelective(SysExpense record);


    SysExpense selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(SysExpense record);


    int updateByPrimaryKey(SysExpense record);
}