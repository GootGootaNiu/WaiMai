package com.king.waimai.mapper;

import com.king.waimai.pojo.Dish;
import com.king.waimai.pojo.Orders;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class OrdersTest {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void mains(){
        List<Orders> orders = ordersMapper.selectAll();
        for (Orders o :
                orders) {
            System.out.println(o);
        }
    }

}
