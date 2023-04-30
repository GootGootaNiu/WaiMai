package com.king.waimai.mapper;

import com.king.waimai.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void userAll(){
        List<User> users =
                userMapper.selectAll();
        for (User user:users
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void userAllPhone(){
        User user = userMapper.selectPhone("");
        System.out.println(user);
    }
}
