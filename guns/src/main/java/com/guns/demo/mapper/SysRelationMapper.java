package com.guns.demo.mapper;

import com.guns.demo.model.SysRelation;

public interface SysRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_relation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_relation
     *
     * @mbg.generated
     */
    int insert(SysRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_relation
     *
     * @mbg.generated
     */
    int insertSelective(SysRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_relation
     *
     * @mbg.generated
     */
    SysRelation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_relation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_relation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysRelation record);
}