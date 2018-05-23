package com.guns.demo.jpa;

import com.guns.demo.model.SysUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<SysUser,Integer> {


     List<SysUser> findAll();
}
