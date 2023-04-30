package com.king.waimai.mapper;

import com.king.waimai.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll();

    /**
     * 根据用户的电话查询用户的数据
     * @param phone 用户电话
     * @return 返回用户数据
     */
    User selectPhone(String phone);

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    Integer insertAll(User user);
}
