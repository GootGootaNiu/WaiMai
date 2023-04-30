package com.king.waimai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.king.waimai.pojo.Employee;

import java.util.List;

/**
 * 编写配置文件
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回用户的数据
     */
    Employee getSelectByUsername(String username);

    /**
     * 添加用户信息
     * @param employee 用户输入的数据
     * @return 返回受影响行数
     */
    Integer getInsertALl(Employee employee);


    List<Employee> getSelectLimit(String name,Integer page,Integer pageSize);


    /**
     * 分页查询 加 模糊查询
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
    Page getSelectAll(String name ,int page,int pageSize);


    /**
     * 用户修改 和 禁用用户信息
     * @param employee 用户数据
     * @return 返回用户信息
     */
    Integer getUpdateId(Employee employee);

    /**
     * 根据用户id 查询用户数据
     * @param id 用户id
     * @return 返回用户的数据
     */
    Employee getSelectById(Long id);

    Integer updateAll(Employee employee);





}






















