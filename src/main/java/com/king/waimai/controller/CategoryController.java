package com.king.waimai.controller;


import com.king.waimai.common.PageHeabl;
import com.king.waimai.common.R;
import com.king.waimai.pojo.Category;
import com.king.waimai.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 根据type 查询用户的数据
     * @param category 用户输入的对象信息
     * @return 返回用户数据
     */
//    @GetMapping("/list")
//    public R<List<Category>> selectByType( Category category) {
//        List<Category> list = categoryService.selectByType(category.getType());
//        return R.success(list);
//    }
    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        return R.success(categoryService.list(category));
    }

    /**
     * 分页查询用户数据
     * @param page 当前页码
     * @param pageSize 每页多少页码
     * @return 返回返回后的对象信息
     */
    @GetMapping("/page")
    public R<PageHeabl<Category>> selectll(int page, int pageSize) {
        return R.success(categoryService.selectAlls(page, pageSize));
    }


    /**
     * 添加数据
     * @param session 拿到用户id
     * @param category 用户信息
     * @return 返回受影响的行数
     */
    @PostMapping
    public R<String> insertAll(HttpSession session, @RequestBody Category category) {

        String name = category.getName();
        Category byName = categoryService.getSelectByName(name);
        if (byName != null){
            return R.error("菜品数据已存在");
        }
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        Long id = getIdFromSession(session);
        category.setUpdateUser(id);
        category.setCreateUser(id);
        categoryService.insertAlls(category);
        return R.success("数据添加成功");
    }


    @DeleteMapping
    public R<String> deleteById(Long ids){
        categoryService.deleteById(ids);
        return R.success("数据删除成功");
    }


    @PutMapping
    public R<String> updateByType(@RequestBody Category category,HttpSession session){
        // 获取用户的数据
        category.setUpdateTime(new Date());
        Long id = getIdFromSession(session);
        category.setUpdateUser(id);
        categoryService.updateByType(category);
        return R.success("用户数据修改成功");
    }


//    @GetMapping("/page")
//    public R<PageHeabl> getCategoryList(Integer page, Integer pageSize){
//        PageHelper.startPage(page,pageSize);
//        List<Category> categoryList = categoryService.getCategoryList();
//        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
//
//        PageHeabl page1 = new PageHeabl(pageInfo.getPageNum(), pageInfo.getSize());
//        BeanUtil.copyProperties(pageInfo,page1,"list");
//        page1.setRecords(pageInfo.getList());
//        return R.success(page1);
//    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
//    @GetMapping("/page")
//    public R<PageHeabl> page(int page, int pageSize){
//        //分页构造器
//        PageHeabl<Category> pageInfo = new PageHeabl<>(page,pageSize);
//        //条件构造器
//        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
//        //添加排序条件，根据sort进行排序
//        queryWrapper.orderByAsc(Category::getSort);
//
//        //分页查询
//        categoryService.page(pageInfo,queryWrapper);
//        return R.success(pageInfo);
//    }


}
























