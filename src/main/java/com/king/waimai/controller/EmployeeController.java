package com.king.waimai.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.king.waimai.common.R;

import lombok.extern.slf4j.Slf4j;
import com.king.waimai.pojo.Employee;
import com.king.waimai.service.EmployeeService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    @Resource
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpSession session, @RequestBody Employee employee) {
        // 1 第一步：将用户提交的密码password 进行md5 加密处理
        String password = employee.getPassword();
        // 进行加密在交给password
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2, 第二步；根据页码提交的用户名username 查询数据库
        String username = employee.getUsername();

        // 兄弟 这个地方根据用户名查询用户的数据局
        // 如果是空就退出
        Employee emp = employeeService.getSelectByUsername(username);
        // 3, 第三步：判断用户的数据是不是为空 如果为空就直接return
        if (emp == null) {
            return R.error("登录失败");
        }

        // 4, 密码比对 如果不一致返回登录失败的结果
        if (!emp.getPassword().equals(password)) {
            return R.error("密码不正确");
        }

        // 5 第五步： 成立密码就比对成功了
        // 查看员工状态 如果为已禁用 则饭后员工已禁用结果
        if (emp.getStatus() == 0) {
            return R.error("账号已被禁用");
        }

        // 6 账号正常 可以进入 这里需要把账户的id 和 username放到里面
        // 把id 放到域中去
//        request.getSession().setAttribute("employee", emp.getId());
        // 把数据放到域中去
        session.setAttribute("id",emp.getId());
//        session.setAttribute("name",emp.getName());
        // 这里返回成功把用户的数据也给返回出去
        return R.success(emp);

    }


    /**
     * 员工退出功能
     *
     * @param request 清理session
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request,HttpSession session) {
        // 清理Session中保存的当前登录员工的id
//        request.getSession().removeAttribute("employee");
        session.removeAttribute("uid");
        return R.success("退出成功");
    }

    /**
     * 添加用户数据
     *
     * @param session  从域中拿到数据
     * @param employee 用户传入的数据
     * @return 返回添加员工信息成功
     */
    @PostMapping
    public R<String> insert(HttpSession session, @RequestBody Employee employee) {

        // 先查询根据用户名是否能拿到数据
        Employee username = employeeService.getSelectByUsername(employee.getUsername());
        if (username != null) {
            String usernames = username.getUsername();
            return R.error(usernames + "已存在");
        }

        // 第一步：拿到用户的数据之后 对密码进行加密
        // DigetUtils.md5DigestAsHex("设置初始密码".getBytes())
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        // 第二步： 添加时间添加人 和 修改时间 修改人
        employee.setCreateTime(new Date()); // 添加时间
        employee.setUpdateTime(new Date()); // 修改时间




        // 第三步：获取当前登录用户的id
//        Long empId = (Long) request.getSession().getAttribute("employee");
        // 获取session中的id
        Long empId = getIdFromSession(session);
//        Long id = getidFromSession(request);
        employee.setCreateUser(empId);
//        employee.setCreateUser(empId);// 添加人是谁
        employee.setUpdateUser(empId);// 修改人是谁

        // 修改信息
        Integer count = employeeService.getInsertALl(employee);
        System.out.println("添加成功" + count);
        return R.success("新增员工成功");
    }

//    /**
//     * 员工信息分页查询
//     *  这个是老师 写的 ok 的
//     * @param page
//     * @param pageSize
//     * @param name
//     * @return
//     */
//    @GetMapping("/page")
//    public R<PageHeabl> page(int page, int pageSize, String name) {
//        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,name);
//        //构造分页构造器
//        PageHeabl pageInfo = new PageHeabl(page, pageSize);
//
//        //构造条件构造器
//        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
//        //添加过滤条件
//        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
//        //添加排序条件
//        queryWrapper.orderByDesc(Employee::getUpdateTime);
//        //执行查询
//        employeeService.page(pageInfo, queryWrapper);
//
//        return R.success(pageInfo);
//    }


    /**
     * 分页查询 加 模糊查询
     *
     * @param name     用户名
     * @param page     当前页数
     * @param pageSize 每页多少条
     * @return 返回数据
     */
    @GetMapping("/page")
    public R<Page> getSelectAlls(String name, int page, int pageSize) {
        Page page1 = employeeService.getSelectAll(name, page, pageSize);
        return R.success(page1);
    }

    @PutMapping
    public R<String> getUpdate(@RequestBody Employee employee,HttpSession session, HttpServletRequest request) {
        employee.setCreateTime(new Date()); // 添加时间
        employee.setUpdateTime(new Date()); // 修改时间

        // 第三步：获取当前登录用户的id
//        Long empId = (Long) request.getSession().getAttribute("employee");
        // 拿到用户的数据
        Long empId = getIdFromSession(session);


        employee.setCreateUser(empId);// 添加人是谁
        employee.setUpdateUser(empId);// 修改人是谁
        Integer count = employeeService.getUpdateId(employee);
        System.out.println("修改成功" + count);

        return R.success("禁用成功");
    }

    /**
     * 根据id 查询用户失败
     * 注意：@PathVariable 他是用来获取url 中的数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getSelectById(@PathVariable Long id) {

        Employee employee = employeeService.getSelectById(id);
        if (employee == null) {
            return R.error("用户数据找不到");
        }

        return R.success(employee);
    }


//    public R<String> getUpdateAll(HttpSession session,HttpServletRequest request, @RequestBody Employee employee) {
//       // Long byId = (Long) request.getSession().getAttribute("employee");
//        Long byId = getIdFromSession(session);
//        employee.setUpdateTime(new Date());
//        employee.setUpdateUser(byId);
//        Integer count = employeeService.getUpdateId(employee);
//        System.out.println("修改成功" + count);
//        return R.success("修改成功");
//    }

}
























