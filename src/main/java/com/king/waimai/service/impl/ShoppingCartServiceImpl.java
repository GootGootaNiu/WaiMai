package com.king.waimai.service.impl;

import com.king.waimai.mapper.ShoppingCartMapper;
import com.king.waimai.pojo.ShoppingCart;
import com.king.waimai.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<ShoppingCart> selectAll() {
        return shoppingCartMapper.selectAll();
    }

    @Override
    public List<ShoppingCart> selectByUserId(Long userId) {
        return shoppingCartMapper.selectByUserId(userId);
    }


    /**
     * 添加数据到购物车中
     *
     * @param shoppingCart
     * @param userId
     * @return
     */
    @Override
    public ShoppingCart add(ShoppingCart shoppingCart, Long userId) {
        shoppingCart.setUserId(userId);
        ShoppingCart cart = shoppingCartMapper.addOne(shoppingCart);
        if (cart == null) {
            shoppingCart.setNumber(1);
            shoppingCartMapper.add(shoppingCart);
            return shoppingCart;
        } else {
            // 如果不是空就让他加一
            cart.setNumber(cart.getNumber() + 1);
            cart.setAmount(cart.getAmount().add(shoppingCart.getAmount()));
            shoppingCartMapper.update(cart);
        }
        return cart;
    }

    @Override
    public Boolean clean(Long userId) {
        return shoppingCartMapper.deleteByUserId(userId);
    }


}
