package com.guns.demo.jpa;

import com.guns.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/3/10.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
