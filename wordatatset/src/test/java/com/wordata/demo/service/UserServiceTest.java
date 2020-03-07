package com.wordata.demo.service;

import com.wordata.demo.domain.User;
import com.wordata.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    User user;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
        user = new User();
        user.setLoginId("jinsu1");
        user.setPassword("test123");
        user.setName("jinsu");
        user.setUserType("admin");
        user.setDepartment("test");

        userService.signup(user);
    }

}