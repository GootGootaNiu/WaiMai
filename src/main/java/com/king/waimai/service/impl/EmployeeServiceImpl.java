package com.king.waimai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.king.waimai.mapper.EmployeeMapper;
import com.king.waimai.pojo.Employee;
import com.king.waimai.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return 饭后用户的数据
     */
    @Override
    public Employee getSelectByUsername(String username) {
        return employeeMapper.selectByUsername(username);
    }

    /**
     * 添加用户信息
     *
     * @param employee 用户输入的数据
     * @return 返回受影响的行数
     */
    @Override
    public Integer getInsertALl(Employee employee) {
        return employeeMapper.insertALl(employee);
    }

    @Override
    public List<Employee> getSelectLimit(String name,Integer page, Integer pageSize) {
        return employeeMapper.selectLimit(name,page,pageSize);
    }

    /**
     * 分页 加 模糊 处理
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page getSelectAll(String name, int page, int pageSize) {
        // 分页插件
        // page 第一页
        // pageSize 每页展示多少条数据
        PageHelper.startPage(page,pageSize);

        // 根据name 动态的查询数据
        List<Employee> employees = employeeMapper.selectAlls(name);

        //PageInfo 用PageInfo对结果进行包装
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        // mybatis-plus 中的分页插件 获取PageInfo 中的 第一页PageNum  展示多少数据getSize
        Page page1 = new Page(pageInfo.getPageNum(), pageInfo.getSize());

        BeanUtil.copyProperties(pageInfo,page1,"list");

        page1.setRecords(pageInfo.getList());

        return page1;
    }


    /**
     * 禁用用户信息
     * @param employee 用户数据
     * @return
     */
    @Override
    public Integer getUpdateId(Employee employee) {
        return employeeMapper.updateId(employee);
    }

    /**
     * 根据用户id 查询用户数据
     * @param id 用户id
     * @return 用户id
     */
    @Override
    public Employee getSelectById(Long id) {
        return employeeMapper.selectById(id);
    }

    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    @Override
    public Integer updateAll(Employee employee) {
        return employeeMapper.updateAll(employee);
    }


//


//
//    @Override
//    public List<Employee> getSelectLimit(Integer pageNum,String name) {
//
//        return employeeMapper.selectLimit();
//    }

//    @Override
//    public List<Employee> getSelectLimit(UserPageRequest userPageRequest) {
//        String name = userPageRequest.getName();
//        Integer page = userPageRequest.getPage();
//        Integer pageSize = userPageRequest.getPageSize();
//
//        // 分页
//        PageHelper.startPage(page,pageSize);
//        return employeeMapper.selectLimit(name,page,pageSize);
//    }


//
//    @Override
//    public List<Employee> selectEmpPage(String name, Integer startRow) {
//        return employeeMapper.selectLike(name,startRow);
//    }
//
//    @Override
//    public Integer getRowCount(String name) {
//        return employeeMapper.getRowCount(name);
//    }
}
