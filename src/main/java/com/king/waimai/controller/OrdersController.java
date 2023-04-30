package com.king.waimai.controller;


import com.king.waimai.common.PageHeabl;
import com.king.waimai.common.R;
import com.king.waimai.dto.DishDto;
import com.king.waimai.pojo.Dish;
import com.king.waimai.pojo.DishFlavor;
import com.king.waimai.pojo.Orders;
import com.king.waimai.service.DishFlavorService;
import com.king.waimai.service.DishService;
import com.king.waimai.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrdersController extends BaseController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/page")
    public R<PageHeabl<Orders>> selectByLimit(Integer page, Integer pageSize, String number) {
        return R.success(ordersService.selectLimit(page, pageSize, number));
    }


}
























