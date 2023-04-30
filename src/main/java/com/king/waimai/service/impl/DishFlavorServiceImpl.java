package com.king.waimai.service.impl;


import com.king.waimai.mapper.DishFlavorMapper;

import com.king.waimai.pojo.DishFlavor;
import com.king.waimai.service.DishFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



// extends ServiceImpl<CategoryMapper, Category> implements CategoryService
@Service
public class DishFlavorServiceImpl implements DishFlavorService {

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 添加套餐
     * @param dishFlavor 口味数据
     * @return
     */
    @Override
    public Integer insertFlavor(DishFlavor dishFlavor) {
        return dishFlavorMapper.insertFlavor(dishFlavor) ;
    }
}
