package com.king.waimai.dto;


import com.king.waimai.pojo.Dish;
import com.king.waimai.pojo.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * @Classname DishDto
 * @Description 展示层与服务层数据对应
 * @Date 2023/3/20 17:25
 * @Author wyf
 */
@Data
public class DishDto extends Dish {
    /**
     * list 这个是前段发送过来的数据是list 集合 使用这个接收数据
     */
    private List<DishFlavor> flavors = new ArrayList<>();

    // 展示数据到前端页面上去
    private String categoryName;

    // 这个返回给前端的数据
    private Integer copies;

}
