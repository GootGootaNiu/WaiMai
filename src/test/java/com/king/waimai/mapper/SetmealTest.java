package com.king.waimai.mapper;

import com.king.waimai.pojo.Setmeal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class SetmealTest {

    @Autowired
    private SetmealMapper setmealMapper;

    /**
     * 查询用户全部信息
     */
    @Test
    public void selectAll(){
        List<Setmeal> list =
                setmealMapper.selectAll();
        // 查询全部用户信息
        for (Setmeal c:list
             ) {
            System.out.println(c);
        }
    }





















}
