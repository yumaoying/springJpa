package com.bjyada.demo.service;

import com.bjyada.demo.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
public interface UserService {
    User findById(Integer id);
    User save(String name);
    List<User> findAll();
}
