package com.guns.demo.jpa;

import com.guns.demo.model.Student;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/3/19.
 */
//@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {




}
