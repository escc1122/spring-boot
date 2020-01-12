package com.example.mybatis.Service;

import com.example.mybatis.PO.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserServiceTest2 {
    @Autowired
    private UserService user;

    @Test
    void selectUserByIdForXml() {

        User u = user.selectUserByIdForXml(5);
        System.out.println(u.getId());
    }

}
