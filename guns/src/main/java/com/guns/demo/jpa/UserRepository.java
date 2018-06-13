package com.guns.demo.jpa;

import com.guns.demo.model.SysDept;
import com.guns.demo.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Integer> {


    @Query(value="select name  from sys_user where id=:id",nativeQuery=true)
    String find(@Param("id") Integer id);






}
