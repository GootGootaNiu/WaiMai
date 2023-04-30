package com.king.waimai.service;

import com.king.waimai.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> selectAll();

    /**
     * 根据用户id 查询用户数据
     * @param userId
     * @return
     */
    List<ShoppingCart> selectByUserId(Long userId);

    /**
     * 添加数据到购物车中
     * @param shoppingCart
     * @param userId
     * @return
     */
    ShoppingCart add(ShoppingCart shoppingCart,Long userId);

    /**
     * 删除购物车中的数据
     * @param userId
     * @return
     */
    Boolean clean(Long userId);
}
