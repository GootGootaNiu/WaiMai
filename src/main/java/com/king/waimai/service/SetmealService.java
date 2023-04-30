package com.king.waimai.service;


import com.king.waimai.common.PageHeabl;
import com.king.waimai.dto.SetmealDto;
import com.king.waimai.pojo.Setmeal;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface SetmealService {


    /**
     * 插入用户数据
     *
     * @param setmeal 用户数据
     * @return 返回受影响的行数
     */
    Integer insertAll(Setmeal setmeal);

    /**
     * 分页查询
     *
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
    PageHeabl<SetmealDto> selectByName(String name, Integer page, Integer pageSize);


    /**
     * 根据用户的id 删除用户的数据信息
     * @param ids 用户id
     * @return 返回受影响的行数
     */
    Integer deleteByIdss(List<Long> ids);

    /**
     * 0 禁用 1 启用
     * @param status
     * @param ids
     * @return
     */
    Integer updateByIds(Integer status ,Long[] ids );

    /**
     * 根据id 查询用户数据
     * @param id 用户categoryId
     * @return
     */
    Setmeal selectById(Long id);


    /**
     * 修改套餐管理
     * @param setmealDto
     * @return
     */
    Integer update(HttpSession session, SetmealDto setmealDto);

    /**
     * 根据用户的套餐的id 和 状态查询 使用dto类
     * @param categoryId
     * @param status
     * @return
     */
//    List<Setmeal> list(Long categoryId,Integer status);
    List<SetmealDto> list(Long categoryId,Integer status);
}
