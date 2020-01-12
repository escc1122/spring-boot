package com.example.demo.Service;

import com.example.demo.Po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void findUserById() {
        System.out.println(userService.findUserById(1).getName());
        System.out.println(userService.findUserById(1).getName());
        System.out.println(userService.findUserById(1).getName());
        userService.remove(1);
    }
    @Test
    void save() {
        System.out.println("save_test");
        User uesr = new User(5,"put_test",5,5);
        userService.saveUser(uesr);
        System.out.println(userService.findUserById(uesr.getId()).getName());
        userService.remove(5);
    }
}