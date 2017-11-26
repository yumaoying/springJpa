package com.bjyada.demo.dao;

import com.bjyada.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/16.
 */
public interface UserDao extends JpaRepository<User,Serializable>{
    User findById(Integer id);
}
