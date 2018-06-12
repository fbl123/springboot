package com.huijie.demo.jpa;

import com.huijie.demo.model.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<SysDept,Integer> {



}
