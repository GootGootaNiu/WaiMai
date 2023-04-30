package com.king.waimai.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.king.waimai.common.PageHeabl;
import com.king.waimai.dto.DishDto;
import com.king.waimai.mapper.CategoryMapper;
import com.king.waimai.mapper.DishFlavorMapper;
import com.king.waimai.mapper.DishMapper;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Dish;
import com.king.waimai.pojo.DishFlavor;
import com.king.waimai.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// extends ServiceImpl<CategoryMapper, Category> implements CategoryService
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 分页查询之多表联查
     *
     * @param name     用户名称
     * @param page     当前页码
     * @param pageSize 每页多少条数据
     * @return 返回用户的数据
     */
    @Override
    public PageHeabl<DishDto> queryDishList(String name, Integer page, Integer pageSize) {
        // 第一步：用户输入过来的数据进行分页处理
        List<Dish> dishList = dishMapper.selectByName(name, (page - 1) * pageSize, pageSize);
        // 第二步：创建分页对象 // 把查询到的数据放入进去
        PageHeabl<DishDto> dtoPage = new PageHeabl<>();
        // 第三步：dtoPage 这个是为了让分页类拿到数据
        dtoPage.setPage(page);
        // 第四步 把每页多少数据放入进去
        dtoPage.setPageSize(pageSize);
        // 第五步：拿到每一页的count 页码
        int count = dishMapper.count();
        dtoPage.setTotal(count);

        // 第六步：比较难 分析需要注意
        // 通过上面的dishList拿到上面的数据
        List<DishDto> listDto = dishList.stream().map((dish) -> {
            // 第七步：创建DishDto 对象
            DishDto dto = new DishDto();
            // 第八步 对这个对象进行赋值
            BeanUtils.copyProperties(dish, dto);
            // 第九步： 创建category 对象
            Category category = new Category();
            // 第十步： 通过category 赋值给他id
            category.setId(dish.getCategoryId());
            // 第十一步： 拿到category 中的数据
            List<Category> categoryList = categoryMapper.selectBycategory(category);
            // 第十二步： 根据dto 中的数据 拿到CategoryName
            dto.setCategoryName(categoryList.get(0).getName());
            // 第十三步：根据dish_id 查询用户的数据
            dto.setFlavors(dishFlavorMapper.selectByDishId(dish.getId()));
            return dto;
        }).collect(Collectors.toList());
        dtoPage.setRecords(listDto);
        return dtoPage;
    }


    /**
     * 分页查询 加多表联查
     *
     * @param name     用户输入的名称
     * @param page     当前页数
     * @param pageSize 展示多少条数据
     * @return 返回查询到的数据
     */
    @Override
    public PageHeabl<Dish> getSelectByName(String name, Integer page, Integer pageSize) {
        return null;
    }


    /**
     * 添加菜品数据
     *
     * @param dishDto 用户数据
     * @return 返回受影响的 行数
     */
    @Override
    public Integer insertAll(DishDto dishDto) {
        return dishMapper.insertAll(dishDto);
    }

    @Override
    public Dish getByName(String name) {
        return dishMapper.getByName(name);
    }

    /**
     * 查询出两张表的数据
     * @param dto
     * @return
     */
    @Override
    public List<DishDto> list(DishDto dto) {
        List<Dish> list = dishMapper.getBydIshCategoryId(dto.getCategoryId());
        List<DishDto> list1 = list.stream().map((dish)->{
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(dish,dishDto);
            dishDto.setFlavors(dishFlavorMapper.selectByDishId(dish.getId()));
            return dishDto;
        }).collect(Collectors.toList());
        return list1;
    }

    /**
     * 根据用户的categoryId
     *
     * @param categoryId 根据id 查询用户的数据
     * @return
     */
//    @Override
//    public List<Dish> getSelectCategoryId(Long categoryId) {
//        return dishMapper.getBydIshCategoryId(categoryId);
//    }

    /**
     * 根据用户的id 删除用户的数据
     *
     * @param ids 用户id
     * @return 返回受影响的行数
     */
    @Override
    public Integer deleteByIds(List<Long> ids) {
        for (Long id : ids
        ) {
            dishMapper.deleteById(id);
            dishFlavorMapper.deleteById(id);
        }
        return null;
    }

    /**
     * 0 禁用1启用
     * @param status 状态信息
     * @param id 用户id
     * @return
     */
    @Override
    public Integer updateByStatus(Integer status, Long[] id) {
        return dishMapper.updateStatus(status,id);
    }

    /**
     * 根据用户的id 查询数据
     * @param id
     * @return
     */
    @Override
    public Dish selectByDish(Long id) {
        // 第一步：先查询出来数据
        Dish dish = dishMapper.selectByIds(id);
        // 第二步： 创建dto类的对象
        DishDto dto = new DishDto();
        //通过 工具类把数据赋值给他们
        BeanUtils.copyProperties(dish,dto);
        // 赋值完成之后 这里进行第二次查询
        dto.setFlavors(dishFlavorMapper.selectByDishId(id));
        return dto;
    }

    /**
     * 修改菜品信息
     * @param session 会话
     * @param dishDto 菜品数据
     * @return
     */
    @Override
    public Integer updateAll(HttpSession session, DishDto dishDto) {
        dishDto.setUpdateTime(new Date());
        dishDto.setIsDeleted(1);
        dishDto.setSort(0);
        dishDto.setUpdateUser((Long) session.getAttribute("id"));
        dishMapper.updateAll(dishDto);
        dishFlavorMapper.deleteById(dishDto.getId());

        for (DishFlavor flavor : dishDto.getFlavors()) {
            // 把数据保存到里面
            flavor.setDishId(1L);
            flavor.setSort(0);
            flavor.setCreateTime(new Date());
            flavor.setUpdateTime(new Date());
            flavor.setUpdateUser((Long) session.getAttribute("id"));
            flavor.setCreateUser((Long) session.getAttribute("id"));
            // 插入数据
            dishFlavorMapper.insertFlavor(flavor);
        }

        return null;
    }


}
