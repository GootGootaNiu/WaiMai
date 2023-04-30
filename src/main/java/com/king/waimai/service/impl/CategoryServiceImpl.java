package com.king.waimai.service.impl;


import com.king.waimai.common.PageHeabl;
import com.king.waimai.mapper.CategoryMapper;
import com.king.waimai.pojo.Category;
import com.king.waimai.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// extends ServiceImpl<CategoryMapper, Category> implements CategoryService
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

//
//    @Override
//    public List<Category> getSelectAll() {
//        List<Category> categories = categoryMapper.selectAll();
//        return categories;
//    }

//    @Override
//    public List<Category> getCategoryList() {
//        List<Category> categoryList = categoryMapper.getCategoryList();
//        return categoryList;
//    }

    /**
     * 分页查询 这里需要把用户的数据给进行分页
     * @param page 算出来的数据
     * @param pageSize 用户页码
     * @return
     */
    @Override
    public PageHeabl<Category> selectAlls(int page, int pageSize) {
        // 把拿到的数据进行封装
        // 把拿到的数据进行计算
        List<Category> page1 = categoryMapper.selectAlls((page - 1) * pageSize, pageSize);
        PageHeabl<Category> page2 = new PageHeabl<>();
        // 传入 每页展示多少条记录
        page2.setPageSize(pageSize);
        page2.setPage(page);
        page2.setTotal(categoryMapper.count());
        page2.setRecords(page1);
        // 传入当前页码
        // 传入一共多少条数据
        // 传入 计算之后拿到数据
        return page2;
    }

    /**
     * 添加用户数据
     * @param category 用户输入的数据
     * @return
     */
    @Override
    public Integer insertAlls(Category category) {
        return categoryMapper.insertAll(category);
    }

    /**
     * 根据用户的id 删除用户的数据
     * @param id 菜品id
     * @return 返回受影响的行数
     */
    @Override
    public Integer deleteById(Long id) {
        return categoryMapper.deleteById(id);
    }

    /**
     * 修改用户信息
     * @param category 用户数据
     * @return 返回受影响的行数
     */
    @Override
    public boolean updateByType(Category category) {
        return categoryMapper.updateByType(category);
    }

    /**
     * 根据用户的name 查询用户的数据
     * @param name 用户名称
     * @return 返回受影响的行数
     */
    @Override
    public Category getSelectByName(String name) {
        return categoryMapper.SelectByName(name);
    }

    @Override
    public List<Category> selectByType(Integer type) {
        return categoryMapper.selectByType(type);
    }

    /**
     *
     * @param category
     * @return
     */
    @Override
    public List<Category> list(Category category) {
        return categoryMapper.list(category);
    }


}
