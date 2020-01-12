package com.example.demo.Service;

import com.example.demo.Po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void insertUser() {
        System.out.println("insertUser");
        userService.insertUser("test1",50,50.0);
        userService.insertUser("test2",50,50.0);
    }

    @Test
    void findUserByName() {
        System.out.println(userService.findUserByName("test1"));
    }

    @Test
    void findUserByNameForXml() {
        System.out.println(userService.findUserByNameForXml("test2"));
    }

    @Test
    void findAllUser() {
        List<User> uesrList = userService.findAllUser();

    }


    @Test
    void updateUser() {
        userService.insertUser("test3",50,50.0);
        User user = userService.findUserByName("test3");
        userService.updateUser("test3",33,555.0,user.getId());
        userService.deleteUser(user.getId());
    }

    @Test
    void deleteUser() {
        User user = userService.findUserByName("test1");
        userService.deleteUser(user.getId());
    }

    @Test
    void deleteUserByName() {
        userService.deleteUserByName("test2");
    }

}