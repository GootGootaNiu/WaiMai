package com.king.waimai.mapper;

import com.king.waimai.pojo.AddressBook;
import com.king.waimai.pojo.ShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ShoppingCartTest {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 查询用户全部信息
     */
    @Test
    public void selectAll() {
        List<ShoppingCart> list =
                shoppingCartMapper.selectAll();
        // 查询全部用户信息
        for (ShoppingCart c : list
        ) {
            System.out.println(c);
        }
    }

}
