package com.king.waimai.mapper;

import com.king.waimai.pojo.DishFlavor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class DishFlavorTest {

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 查询全部数据
     */
    @Test
    public void selectAll(){
        List<DishFlavor> list =
                dishFlavorMapper.selectAll();
        // 查询全部数据
        for (DishFlavor lists:list
             ) {
            System.out.println(lists);
        }
    }

}
