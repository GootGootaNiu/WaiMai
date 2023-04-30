package com.king.waimai.mapper;

import com.king.waimai.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 查询全部数据
     * @return
     */
    List<ShoppingCart> selectAll();

    /**
     * 根据用户id 查询用户数据
     * @param userId
     * @return
     */
    List<ShoppingCart> selectByUserId(Long userId);

    /**
     * 添加到购物车中
     * @param shoppingCart
     * @param
     * @return
     */
    Boolean add(ShoppingCart shoppingCart);

    /**
     * 条件查询用户的id
     * @param shoppingCart
     * @return
     */
    ShoppingCart addOne(ShoppingCart shoppingCart);

    public boolean update(ShoppingCart shoppingCart);

    /**
     * 清空购物车
     * @param userId
     * @return
     */
    boolean deleteByUserId(Long userId);

}
