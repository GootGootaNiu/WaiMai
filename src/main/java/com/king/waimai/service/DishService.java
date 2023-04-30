package com.king.waimai.service;

import com.king.waimai.common.PageHeabl;
import com.king.waimai.dto.DishDto;
import com.king.waimai.pojo.Dish;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 编写配置文件
 * extends IService<Category>
 */
public interface DishService {

    /**
     * 根据用户的名字进行分页查询
     *
     * @param name     用户输入的名称
     * @param page     当前页数
     * @param pageSize 展示多少条数据
     * @return 返回菜品数据
     */
//    PageHeabl<Dish> getSelectByName(String name, Integer page, Integer pageSize);
    PageHeabl<Dish> getSelectByName(String name, Integer page, Integer pageSize);


    /**
     * 分页查询 根据用户名称查询用户数据
     * @param name 用户名称
     * @param page 当前页码
     * @param pageSize 展示多少数据
     * @return 返回 用户信息
     */
    PageHeabl<DishDto> queryDishList(String name, Integer page, Integer pageSize);


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
     *
     * @param dto
     * @return
     */
//    List<Dish> getSelectCategoryId(Long categoryId);
    public List<DishDto> list(DishDto dto);//categoryId

    /**
     * 根据用户的id id 删除用户的数据
     * @param ids 用户id
     * @return 返回受影响的行数
     */
    Integer deleteByIds(List<Long> ids);

    /**
     * 0 禁用 1 启用
     * @param status 状态信息
     * @param id 用户id
     * @return 返回受影响的行数
     */
    Integer updateByStatus(Integer status , Long[] id);

    /**
     * 根据id 进行数据查询
     * @param id
     * @return
     */
    Dish selectByDish(Long id);

    /**
     * 修改用户菜品数据
     * @param session 会话
     * @param dishDto 菜品数据
     * @return
     */
    Integer updateAll(HttpSession session , DishDto dishDto);

}






















