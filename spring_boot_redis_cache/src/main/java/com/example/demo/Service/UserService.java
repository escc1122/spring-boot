package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Po.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;


    /**
     * 根据名字查找用户
     */
    @Cacheable(value = "user", key = "#id")
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @CachePut(value = "user", key = "#user.id")
    //必需要return 不然會cache到null
    public User saveUser(User user) {
        userDao.saveUser(user);
        return user;
    }

    @CacheEvict(value = "user", key = "#id")
    public void remove(int id) {

    }

}