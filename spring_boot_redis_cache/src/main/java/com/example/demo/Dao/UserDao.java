package com.example.demo.Dao;

import com.example.demo.Po.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {
    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    static {
        USER_MAP.put(1, new User(1, "中文測試", 18,18.0));
        USER_MAP.put(2, new User(2, "中文測試2", 19,18.0));
        USER_MAP.put(3, new User(3, "test3", 20,18.0));
    }
    /**
     * 通过名字查询用户信息
     */
    public User findUserById(int id){
        System.out.println("findUserById");
        return USER_MAP.get(id);
    }

    public void saveUser(User user) {
        System.out.println("saveUser");
        USER_MAP.put(user.getId(), user);
    }
}
