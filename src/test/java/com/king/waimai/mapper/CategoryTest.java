package com.king.waimai.mapper;

import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
public class CategoryTest {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询用户全部信息
     */
    @Test
    public void selectAll(){
        List<Category> list =
                categoryMapper.selectAll();
        // 查询全部用户信息
        for (Category c:list
             ) {
            System.out.println(c);
        }
    }

    @Test
    public void inserAll(){
        Category category = new Category();
        category.setName("老干妈");
        category.setSort(20);
        category.setType(1);
        category.setUpdateUser(1L);
        category.setUpdateTime(new Date());
        category.setCreateTime(new Date());
        category.setCreateUser(1L);
        Integer count = categoryMapper.insertAll(category);
        System.out.println(count+"添加成功");
    }




















}
