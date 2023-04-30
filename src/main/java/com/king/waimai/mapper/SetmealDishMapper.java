package com.king.waimai.mapper;


import com.king.waimai.pojo.DishFlavor;
import com.king.waimai.pojo.Setmeal;
import com.king.waimai.pojo.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// extends BaseMapper<Category>
@Mapper
public interface SetmealDishMapper {

    /**
     * 查询全部
     *
     * @return
     */
    List<SetmealDish> selectAll();

    /**
     * 根据id查询用户数据
     * @param id
     * @return
     */
//    List<SetmealDish> selectById(Long id);

    /**
     * 套餐菜品关系 中插入数据
     *
     * @param setmealDish
     * @return
     */
    Integer insertAll(SetmealDish setmealDish);

    /**
     * 根据id 查询用户的数据
     *
     * @param id 用户id
     * @return 返回的用户数据
     */
    List<SetmealDish> selectByID(Long id);

    /**
     * 根据用户的id删除用户数据
     *
     * @param id 用户id
     * @return 返回受影响的行数
     */
    Integer deleteByIds(Long id);

    /**
     * 根据id 查询用户数据
     *
     * @param setmealId
     * @return
     */
    List<SetmealDish> selectByDishId(Long setmealId);


}
