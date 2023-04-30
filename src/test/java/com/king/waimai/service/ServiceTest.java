package com.king.waimai.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.king.waimai.common.R;
import com.king.waimai.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ServiceTest {

    @Autowired
    private EmployeeService employeeService;


    @Test
    public void page() {
        Integer page = 1;
        Integer pageSize = 10;
        String  name = "";
        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

//        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
//        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);
//        //执行查询
        employeeService.page(pageInfo,queryWrapper);


    }
}
