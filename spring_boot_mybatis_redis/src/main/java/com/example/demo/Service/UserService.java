package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Cacheable(value = "user_name", key = "#name")
    public User findUserByName(String name)
    {
        return userDao.findUserByName(name);
    }

    @Cacheable(value = "all_user")
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    public void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money) {
        userDao.insertUser(name,age,money);
    }

    public void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money,
                    @Param("id") int id){
        userDao.updateUser(name,age,money,id);
    }

    @CacheEvict(value = "user_id", key = "#id")
    public void deleteUser(@Param("id") int id){
        userDao.deleteUser(id);
    }

    @CacheEvict(value = "user_name", key = "#name")
    public int deleteUserByName(@Param("name") String name){
       return userDao.deleteUserByName(name);
    }


    @Cacheable(value = "user_name", key = "#name")
    public User findUserByNameForXml(@Param("name") String name){
        return userDao.findUserByNameForXml(name);
    }

}