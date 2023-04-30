package com.king.waimai.controller;


import cn.hutool.log.Log;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.king.waimai.common.PageHeabl;
import com.king.waimai.common.R;
import com.king.waimai.dto.DishDto;
import com.king.waimai.mapper.DishFlavorMapper;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Dish;
import com.king.waimai.pojo.DishFlavor;
import com.king.waimai.service.CategoryService;
import com.king.waimai.service.DishFlavorService;
import com.king.waimai.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController extends BaseController {

    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 添加菜品信息
     *
     * @param dishDto
     * @param session
     * @return
     */
    @PostMapping
    private R<String> getDishDto(@RequestBody DishDto dishDto, HttpSession session) {
//        Long sid = getIdFromSession(session);
        dishDto.setCreateTime(new Date());
        dishDto.setUpdateTime(new Date());
        dishDto.setIsDeleted(1);
        dishDto.setSort(0);
        dishDto.setCreateUser((Long) session.getAttribute("id"));
        dishDto.setUpdateUser((Long) session.getAttribute("id"));
        // 创建时候的时间
        // 把Dish 中的数据保存进来
        dishService.insertAll(dishDto);

        // 根据菜品名称查询数据 如果没有菜品名称 查询全部的数据
        Dish byName = dishService.getByName(dishDto.getName());
        // 循环遍历
        // 循环遍历 dishDto 用户传过来的数据  然后把数据放到DishFlavor中去
        for (DishFlavor flavor : dishDto.getFlavors()) {
            // 这里调用DishFlavor把查询出来的id 保存进去
            //flavor.setDishId(byName.getId());
            flavor.setDishId(byName.getId());
            // 把数据保存到里面
            flavor.setDishId(1L);
            flavor.setSort(0);
            flavor.setCreateTime(new Date());
            flavor.setUpdateTime(new Date());
            flavor.setUpdateUser((Long) session.getAttribute("id"));
            flavor.setCreateUser((Long) session.getAttribute("id"));
            dishFlavorService.insertFlavor(flavor);
        }
        return R.success("保存成功");
    }

    /**
     * 分页查询
     *
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
//    @GetMapping("/page")
//    private R<PageHeabl<Dish>> getSelectByName(String name, Integer page, Integer pageSize) {
//        return R.success(dishService.getSelectByName(name, page, pageSize));
//    }

    /**
     * 分页查询 数据层
     *
     * @param name     用户名称
     * @param page     当前页码
     * @param pageSize 一页展示多少数据
     * @return 返回用户的数据
     */
    @GetMapping("/page")
    public R<PageHeabl<DishDto>> queryDishList(String name, Integer page, Integer pageSize) {
        return R.success(dishService.queryDishList(name, page, pageSize));
    }

//    @GetMapping("/page")
//    public R<Page<DishDto>> page(String name,int page,int pageSize)
//    {
//        return R.success(dishService.page(name,page,pageSize));
//    }


//    @GetMapping("list")
//    public R<List<Dish>> getSelectCategoryId(Long categoryId) {
//        return R.success(dishService.getSelectCategoryId(categoryId));
//    }

    @GetMapping("/list")
    public R<List<DishDto>> list(DishDto dto)//categoryId
    {
        return R.success(dishService.list(dto));
    }

    /**
     * 根据用户的id删除数据
     *
     * @param ids 用户id
     * @return 返回受影响的行数
     */
    @DeleteMapping
    public R<String> deleteByIds(@RequestParam List<Long> ids) {
        dishService.deleteByIds(ids);
        return R.success("删除成功");
    }

    @PostMapping("/status/{status}")
    public R<String> updateBystatus(@PathVariable Integer status, Long[] ids) {
        Integer count = dishService.updateByStatus(status, ids);
        if (count == 0) {
            return R.success("禁用成功");
        } else {
            return R.success("启用成功");
        }
    }

    /**
     * 根据id 修改用户数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Dish> selectByDishId(@PathVariable Long id) {
        Dish dish = dishService.selectByDish(id);
        return R.success(dish);
    }

    @PutMapping
    public R<String> updateAll(HttpSession session, DishDto dishDto) {
        dishService.updateAll(session, dishDto);
        return R.success("修改成功");
    }
}
























