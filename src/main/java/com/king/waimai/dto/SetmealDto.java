package com.king.waimai.dto;

import com.king.waimai.pojo.Setmeal;
import com.king.waimai.pojo.SetmealDish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作两张表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetmealDto extends Setmeal {
    /**
     *  以SetmealDish 定义一个集合
     */
    List<SetmealDish> setmealDishes= new ArrayList<>();

    /**
     * 响应数据在前端页码上去
     */
    String categoryName;
}
