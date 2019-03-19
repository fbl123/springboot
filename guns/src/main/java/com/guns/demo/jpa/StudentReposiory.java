package com.guns.demo.jpa;

import com.guns.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/3/19.
 */
//@Repository
public interface StudentReposiory extends JpaRepository<Student,Long> {
}
