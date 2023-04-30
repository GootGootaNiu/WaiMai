package com.king.waimai.mapper;

import com.king.waimai.dto.DishDto;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// extends BaseMapper<Category>
@Mapper
public interface DishMapper {

    /**
     * 查询用户全部数据
     *
     * @return 返回用户的数据
     */
    List<Dish> selectAll();


    /**
     * 根据用户的名字进行分页查询
     *
     * @param name     用户输入的名称
     * @param page     当前页数
     * @param pageSize 展示多少条数据
     * @return 返回菜品数据
     */
    List<Dish> selectByName(String name, Integer page, Integer pageSize);

    /**
     * 查询页码下表
     *
     * @return 返回下表
     */
    int count();


    List<Category> selectById(Long id);
    // 查询

    /**
     * 添加用户数据 在业务层进行处理
     *
     * @param dishDto 用户数据
     * @return 返回受影响的行数
     */
    Integer insertAll(DishDto dishDto);

    /**
     * 根据name 动态的查询用户数据
     *
     * @param name
     * @return
     */
    public Dish getByName(String name);


    /**
     * 根据id查询多个用户数据
     *
     * @param categoryId 用户输入的di
     * @return 返回用户多条记录
     */
    List<Dish> getBydIshCategoryId(Long categoryId);


    /**
     * 根据用户的id 删除用户的数据
     *
     * @param id 用户id
     * @return 返回受影响的行数
     */
    Integer deleteById(Long id);

    /**
     * 0 禁用 1 启用
     * @param status 状态
     * @param id 用户id
     * @return 返回受影响的行数
     */
    Integer updateStatus(@Param("status") Integer status, @Param("id") Long[] id);

    /**
     * 修改页码的sql 语句
     * @param id 用户id
     * @return 返回受影响的行数
     */
    Dish selectByIds(Long id);

    /**
     * 修改菜品信息
     * @param dish 菜品数据
     * @return 返回受影响的行数
     */
    Integer updateAll(Dish dish);

}
