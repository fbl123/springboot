package com.huijie.oa.dao.jpa;

import com.huijie.oa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.Transient;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
