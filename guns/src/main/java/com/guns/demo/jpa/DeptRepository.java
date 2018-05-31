package com.guns.demo.jpa;

import com.guns.demo.model.SysDept;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<SysDept,Integer> {



}
