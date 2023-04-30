package com.king.waimai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.king.waimai.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    // 查询全部数据信息
    List<Employee> selectAll();

    /**
     * 根据用户名称查询用户信息
     * @param username 用户名称
     * @return 返回一条记录
     */
    Employee selectByUsername(@Param("username") String username);

    /**
     * 根据用户对象添加用户数据
     * @param employee 用户数据
     * @return 返回受影响的行数
     */
    Integer insertALl(Employee employee);

    /**
     *
     * @param userPageRequest
     * @return
     */
//    List<Employee> selectLimit(UserPageRequest userPageRequest);


    /**
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    List<Employee> selectLimit(String name,Integer page,Integer pageSize);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<Employee> selectAlls(String name);


    /**
     * 用户对象信息
     * @param employee
     * @return
     */
    Integer updateId(Employee employee);

    /**
     * 根据id 查询用户信息
     * @param id 用户id
     * @return 返回用户对象数据
     */
    Employee selectById(Long id);

    /**
     * 修改员工信息
     * @param employee 员工数据
     * @return 返回受影响的行数
     */
    Integer updateAll(Employee employee);
}
































