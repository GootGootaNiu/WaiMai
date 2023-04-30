package com.king.waimai.service;


import com.king.waimai.common.PageHeabl;
import com.king.waimai.dto.SetmealDto;
import com.king.waimai.pojo.Orders;
import com.king.waimai.pojo.Setmeal;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrdersService {

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param number
     * @return
     */
    PageHeabl<Orders> selectLimit(Integer page,Integer pageSize,String number);
}
