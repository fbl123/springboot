package com.guns.demo.jpa;

import com.guns.demo.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestJpaDAO extends JpaRepository<Test,Long> {
}
