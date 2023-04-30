package com.king.waimai.service.impl;

import com.king.waimai.mapper.SetmealDishMapper;
import com.king.waimai.mapper.SetmealMapper;
import com.king.waimai.pojo.SetmealDish;
import com.king.waimai.service.SetmealDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetmealDishServiceImpl implements SetmealDishService {

    @Autowired
    private SetmealDishMapper setmealDishMapper;

    @Override
    public Integer insertAll(SetmealDish setmealDish) {
        return setmealDishMapper.insertAll(setmealDish);
    }
}
