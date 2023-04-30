package com.king.waimai.mapper;

import com.king.waimai.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询用户全部信息
     */
    @Test
    public void selectAll(){
        List<Employee> employees =
                employeeMapper.selectAll();
        for (Employee e: employees
             ) {
            System.out.println(e);
        }
    }

    /**
     * 根据用户名查询用户数据
     */
    @Test
    public void selectByUsername(){
        String username = "admin";
        Employee employee = employeeMapper.selectByUsername(username);
        System.out.println(employee);
    }

    @Test
    public void insertAll(){
        Employee employee = new Employee();
        employee.setId(null);
        employee.setUsername("zhangsan");
        employee.setName("张三");
        employee.setPassword("123456");
        employee.setPhone("13212321222");
        employee.setSex("1");
        employee.setIdNumber("123212222111111111");
        employee.setStatus(1);
        employee.setCreateTime(new Date()); // 创建时间
        employee.setCreateUser(1L);
        employee.setUpdateTime(new Date()); // 修改时间
        employee.setUpdateUser(1L);
        Integer count = employeeMapper.insertALl(employee);
        System.out.println(count);
    }

//    @Test
//    public void miants(){
//        UserPageRequest userPageRequest = new UserPageRequest();
//        userPageRequest.setName("管理员");
//        List<Employee> employees = employeeMapper.selectLimit(userPageRequest);
//        for (Employee e:
//             employees) {
//            System.out.println(e);
//        }
//    }


}
