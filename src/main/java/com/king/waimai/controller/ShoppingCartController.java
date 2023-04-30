package com.king.waimai.controller;

import com.king.waimai.common.R;
import com.king.waimai.pojo.ShoppingCart;
import com.king.waimai.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/list")
    public R<List<ShoppingCart>> selectAll(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        return R.success(shoppingCartService.selectByUserId(userId));
    }

    //'/shoppingCart/add',
    @PostMapping("/add")
    public R<ShoppingCart> add(HttpSession session, @RequestBody ShoppingCart shoppingCart) {
        Long userId = (Long) session.getAttribute("userId");

        return R.success(shoppingCartService.add(shoppingCart, userId));
    }

        @DeleteMapping("/clean")
//    @PostMapping("/cansub")
    public R<String> delete(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        Boolean clean = shoppingCartService.clean(userId);
        return R.success("购物车数据删除成功");
    }

}










