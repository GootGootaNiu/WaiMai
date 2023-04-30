package com.king.waimai.mapper;


import com.king.waimai.pojo.Orders;
import com.king.waimai.pojo.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// extends BaseMapper<Category>
@Mapper
public interface OrdersMapper {

    /**
     * 查询全部
     *
     * @return
     */
     List<Orders> selectAll();

    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页多少数据
     * @param number 根据用户名称查询
     * @return 返回用户数据
     */
     List<Orders> selectById(String number,Integer page ,Integer pageSize);

    /**
     * 查询返回页码
     * @return
     */
     Integer count();
}

