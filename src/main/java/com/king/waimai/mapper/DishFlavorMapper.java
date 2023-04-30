package com.king.waimai.mapper;


import com.king.waimai.dto.DishDto;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Dish;
import com.king.waimai.pojo.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// extends BaseMapper<Category>
@Mapper
public interface DishFlavorMapper {

    /**
     * 查询用户全部数据
     * @return 返回用户的数据
     */
    List<DishFlavor> selectAll();

    /**
     * 添加口味数据
     * @param dishFlavor 口味数据
     * @return 返回受影响的行数
     */
    Integer insertFlavor(DishFlavor dishFlavor);

    /**
     * 根据id 查询数据
     * @param id
     * @return
     */
     List<DishFlavor> selectByDishId(Long id);

    /**
     * 根据用户的id 删除用户的数据
     * @param id 用户id
     * @return 返回受影响的行数
     */
    Integer deleteById(Long id);

    /**
     * 根据dishId 查询
     * @param dishId
     * @return
     */
    List<DishDto> selectByIds(Long dishId);
}
