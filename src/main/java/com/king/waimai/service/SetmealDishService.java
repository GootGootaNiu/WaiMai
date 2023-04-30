package com.king.waimai.service;


import com.king.waimai.pojo.Setmeal;
import com.king.waimai.pojo.SetmealDish;

public interface SetmealDishService {


    /**
     * 插入用户数据
     *
     * @param setmealDish 用户数据
     * @return 返回受影响的行数
     */
    Integer insertAll(SetmealDish setmealDish);
}
