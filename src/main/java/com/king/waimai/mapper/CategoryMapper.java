package com.king.waimai.mapper;


import com.king.waimai.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// extends BaseMapper<Category>
@Mapper
public interface CategoryMapper{

    /**
     * 查询全部
     * @return
     */
    List<Category> selectAll();

    /**
     * 分页查询
     * @return 分页
     */
//    List<Category> selectByType();

    /**
     * 分页查询所有分类
     */
//    List<Category> getCategoryList();


    /**
     * 查询用户全部数据
     * @return
     */
    List<Category> selectAlls(int page ,int pageSize);

    /**
     * 查询用户的数据有多少条
     * @return
     */
    int count();


    /**
     *  添加用户套餐
     * @param category 用户数据
     * @return 返回受影响的行数
     */
    Integer insertAll(Category category);


    /**
     * 删除菜品
     * @param id
     * @return
     */
    Integer deleteById(Long id);


    /**
     * 根据用户id 修改用户数据
     * @param category 用户数据
     * @return 返回受影响的行数
     */
    boolean updateByType(Category category);

    /**
     * 根据用户的name查询用户的数据
     * @param name
     * @return
     */
    Category SelectByName(String name);


    /**
     * 根据用户的type 查询用户的数据信息
     * @param type
     * @return
     */
    List<Category> selectByType(Integer type);

    /**
     * 查询数据
     * @param category
     * @return
     */
    List<Category> selectBycategory(Category category);

    /**
     * 分页查询数据三
     * @param category
     * @return
     */
    public List<Category> list(Category category);

}
