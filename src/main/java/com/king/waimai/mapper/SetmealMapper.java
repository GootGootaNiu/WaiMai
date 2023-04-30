package com.king.waimai.mapper;


import cn.hutool.log.Log;
import com.king.waimai.common.PageHeabl;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// extends BaseMapper<Category>
@Mapper
public interface SetmealMapper {

    /**
     * 查询全部
     *
     * @return
     */
    List<Setmeal> selectAll();


    /**
     * 插入数据
     *
     * @param setmeal 用户数据
     * @return 返回受影响的行数
     */
    Integer insertAll(Setmeal setmeal);


    /**
     * 分页查询
     *
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
    List<Setmeal> selectByName(String name, Integer page, Integer pageSize);

    /**
     * 返回查询后的页码
     *
     * @return 页码
     */
    Integer count();

    /**
     * 根据id 删除用户的数据
     *
     * @param id 用户id
     * @return 返回受影响的行数
     */
    Integer deleteByIds(Long id);


    /**
     * 根据用户的id 去启用 和禁用菜品信息
     *
     * @param status 0 表示禁用 1 表示启用
     * @param ids    根据id 修改用户数据
     * @return
     */
    Integer updateByIds(@Param("status") Integer status, @Param("id") Long[] ids);


    /**
     * 根据id查询用户数据
     *
     * @param id
     * @return
     */
    Setmeal selectById(Long id);

    /**
     * 根据用户对象修改用户数据
     * @param setmeal 套餐管理数据
     * @return
     */
    Integer updateSetmeal(Setmeal setmeal);


    /**
     * 返回套餐管理
     * @param categoryId 套餐id
     * @param status 套餐状态
     * @return
     */
    List<Setmeal> list(Long categoryId,Integer status);

}























