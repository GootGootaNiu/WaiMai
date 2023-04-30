package com.king.waimai.service;

import com.king.waimai.pojo.AddressBook;
import com.king.waimai.pojo.User;

public interface UserService {
    /**
     * 根据phone 查询用户数据
     * @param phone
     * @return
     */
    User selectByPhone(String phone);

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    Integer insert(User user);


}
