package com.king.waimai.service;


import com.king.waimai.common.PageHeabl;
import com.king.waimai.pojo.Category;

import java.util.List;

/**
 * 编写配置文件
 * extends IService<Category>
 */
public interface CategoryService  {

    /**
     * 分页查询
     * @param
     * @return
     */
//    List<Category> getSelectByType();

//    List<Category> getSelectAll();
//
//    List<Category> getCategoryList();


    /**
     * 查询用户全部数据
     * @return
     */
    PageHeabl<Category> selectAlls(int page , int pageSize);

//    /**
//     * 查询用户的数据有多少条
//     * @return
//     */
//    int count();

    /**
     * 添加 菜品信息 菜品数据
     * @param category 用户输入的数据
     * @return 返回受影响的行数
     */
    Integer insertAlls(Category category);

    /**
     * 根据菜品id 删除数据
     * @param id 菜品id
     * @return 返回用户的数据
     */
    Integer deleteById(Long id);

    /**
     * 修改用户数据
     * @param category 用户数据
     * @return 返回受影响的行数
     */
    boolean updateByType(Category category);

    /**
     * 根据用户的name查询用户的数据
     * @param name
     * @return
     */
    Category getSelectByName(String name);

    /**
     * 根据用户的type 查询用户的数据信息
     * @param type
     * @return
     */
    List<Category> selectByType(Integer type);

    /**
     *
     * @param category
     * @return
     */
    List<Category> list(Category category);

}






















