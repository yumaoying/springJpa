package com.bjyada.demo.service.impl;

import com.bjyada.demo.dao.UserDao;
import com.bjyada.demo.entity.User;
import com.bjyada.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public User findById(Integer id) {
       return userDao.findById(id);
    }

    public User save(String name) {
      return  userDao.save(new User(name));
    }

    public List<User> findAll() {
      return   userDao.findAll();
    }
}
