package com.king.waimai.service.impl;

import com.king.waimai.common.PageHeabl;
import com.king.waimai.dto.SetmealDto;
import com.king.waimai.mapper.CategoryMapper;
import com.king.waimai.mapper.OrdersMapper;
import com.king.waimai.mapper.SetmealDishMapper;
import com.king.waimai.mapper.SetmealMapper;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Orders;
import com.king.waimai.pojo.Setmeal;
import com.king.waimai.pojo.SetmealDish;
import com.king.waimai.service.OrdersService;
import com.king.waimai.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public PageHeabl<Orders> selectLimit(Integer page, Integer pageSize, String number) {
        List<Orders> orders = ordersMapper.selectById(number, (page - 1) * pageSize, pageSize);
        PageHeabl<Orders> pageHeabl = new PageHeabl<>();
        pageHeabl.setPage(page);
        pageHeabl.setPageSize(pageSize);
        pageHeabl.setTotal(ordersMapper.count());
        pageHeabl.setRecords(orders);

        return  pageHeabl;
    }
}
