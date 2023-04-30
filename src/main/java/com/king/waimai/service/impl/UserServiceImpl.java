package com.king.waimai.service.impl;

import com.king.waimai.mapper.UserMapper;
import com.king.waimai.pojo.User;
import com.king.waimai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据电话查询用户信息
     * @param phone
     * @return
     */
    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectPhone(phone);
    }

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    @Override
    public Integer insert(User user) {
        return userMapper.insertAll(user);
    }
}
