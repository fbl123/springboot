package com.guns.demo.mapper;

import com.guns.demo.model.SysLoginLog;

public interface SysLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     *
     * @mbg.generated
     */
    int insert(SysLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     *
     * @mbg.generated
     */
    int insertSelective(SysLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     *
     * @mbg.generated
     */
    SysLoginLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(SysLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysLoginLog record);
}