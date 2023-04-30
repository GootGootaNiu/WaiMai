package com.king.waimai.controller;


import com.king.waimai.common.PageHeabl;
import com.king.waimai.common.R;
import com.king.waimai.dto.SetmealDto;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Setmeal;
import com.king.waimai.pojo.SetmealDish;
import com.king.waimai.service.CategoryService;
import com.king.waimai.service.SetmealDishService;
import com.king.waimai.service.SetmealService;
import com.king.waimai.service.impl.SetmealDishServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController extends BaseController {
    @Autowired
    private SetmealService setmealService;

    @Resource
    private SetmealDishService setmealDishServicel;

    /**
     * 分页查询
     *
     * @param name     用户名
     * @param page     当前页码
     * @param pageSize 展示多少页
     * @return
     */
    @GetMapping("/page")
    private R<PageHeabl<SetmealDto>> selectAll(String name, Integer page, Integer pageSize) {
//        setmealService.selectByName(name, page, pageSize);
        return R.success(setmealService.selectByName(name, page, pageSize));
    }


    /**
     * 添加套餐信息
     *
     * @param setmealDto
     * @param session
     * @return
     */
    @PostMapping
    private R<String> insertAll(@RequestBody SetmealDto setmealDto, HttpSession session) {
        setmealDto.setCreateTime(new Date());
        setmealDto.setUpdateTime(new Date());
        setmealDto.setIsDeleted(1);
        setmealDto.setCreateUser((Long) session.getAttribute("id"));
        setmealDto.setUpdateUser((Long) session.getAttribute("id"));
        // 插入数据
        setmealService.insertAll(setmealDto);
        for (SetmealDish setmealDish : setmealDto.getSetmealDishes()) {
            setmealDish.setSetmealId(setmealDto.getId());
            setmealDish.setIsDeleted(1);
            setmealDish.setSort(0);
            setmealDish.setCreateTime(new Date());
            setmealDish.setUpdateTime(new Date());
            setmealDish.setCreateUser((Long) session.getAttribute("id"));
            setmealDish.setUpdateUser((Long) session.getAttribute("id"));
            setmealDishServicel.insertAll(setmealDish);
        }
        return R.success("保存成功");
    }

    /**
     * 根据用户的id 删除用户的数据
     *
     * @param ids 用户id
     * @return 返回受影响的行数
     */
    @DeleteMapping
    public R<String> deleteByIdss(@RequestParam List<Long> ids) {
        setmealService.deleteByIdss(ids);
        return R.success("删除成功");
    }

    /**
     * 0 禁用 1 启用
     *
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    public R<String> updateByIdAndStatus(@PathVariable Integer status, Long[] ids) {
        Integer count = setmealService.updateByIds(status, ids);
//         判断一下
        if (count == 0) {
            return R.success("停售成功");
        } else {
            return R.success("起售成功");
        }
    }


//    @GetMapping("/{id}")
//    public R<Setmeal> selectById(@PathVariable Long id){
//        Setmeal setmeal = setmealService.selectById(id);
//        System.out.println(setmeal);
//        return R.success(setmeal) ;
//    }

    /**
     * 编辑时根据id获取套餐详情
     */
    @GetMapping("/{id}")
    public R<Setmeal> getSetmealDetail(@PathVariable Long id) {
        Setmeal setmealDetail = setmealService.selectById(id);
        return R.success(setmealDetail);
    }

    @PutMapping
    public R<String> updateSetMealDto(@RequestBody SetmealDto setmealDto,
                                      HttpSession session) {
        setmealService.update(session,setmealDto);
        return R.success("修改数据成功");
    }


    /**
     * 这个是单表查询的 没有使用dto 类
     */
//    @GetMapping("/list")
//    public R<List<Setmeal>> list(Long categoryId,int status){
//       return R.success(setmealService.list(categoryId,status));
//    }

    /**
     * 这个是使用dto类了
     */
    @GetMapping("/list")
    public R<List<SetmealDto>> list(Long categoryId,int status){
        return  R.success(setmealService.list(categoryId,status));
    }


}























