package com.guns.demo.jpa;

import com.guns.demo.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2019/3/20.
 */
public interface ClassRepository extends JpaRepository<Class,Long>{
}
