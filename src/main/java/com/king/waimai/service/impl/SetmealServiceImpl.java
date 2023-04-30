package com.king.waimai.service.impl;

import com.king.waimai.common.PageHeabl;
import com.king.waimai.dto.SetmealDto;
import com.king.waimai.mapper.CategoryMapper;
import com.king.waimai.mapper.SetmealDishMapper;
import com.king.waimai.mapper.SetmealMapper;
import com.king.waimai.pojo.Category;
import com.king.waimai.pojo.Setmeal;
import com.king.waimai.pojo.SetmealDish;
import com.king.waimai.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;

    @Autowired
    private SetmealDishMapper setmealDishMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 添加数据
     *
     * @param setmeal 用户数据
     * @return
     */
    @Override
    public Integer insertAll(Setmeal setmeal) {
        return setmealMapper.insertAll(setmeal);
    }

    /**
     * 分页查询逻辑分析
     *
     * @param name     用户名
     * @param page     页码
     * @param pageSize 展示多少数据
     * @return
     */
    @Override
    public PageHeabl<SetmealDto> selectByName(String name, Integer page, Integer pageSize) {
        // 计算分页查询 然后在把数据传入进去
        List<Setmeal> setmealList = setmealMapper.selectByName(name, (page - 1) * pageSize, pageSize);
        // 第二步：使用dto 类 把查询到的数据传入进去
        PageHeabl<SetmealDto> dtoPageHeabl = new PageHeabl<>();
        dtoPageHeabl.setPage(page);
        dtoPageHeabl.setPageSize(pageSize);
        // 查询出来页码数
        Integer count = setmealMapper.count();
        dtoPageHeabl.setTotal(count);
        // 如果是单表查询的话上面查询出来的数据需要封装到里面去的
        // dtoPageHeabl.setRecords(setmealList);

        //  这里需要定义一个集合把数据拿出来
        List<SetmealDto> dtoList = setmealList.stream().map((setmeal) -> {
            // 第七步：创建 dto 类的对象
            SetmealDto setmealDto = new SetmealDto();
            // 把 setmeal 中的数据拿到 放到setMealDto 中去
            BeanUtils.copyProperties(setmeal, setmealDto);
            // 创建Category category = new Category(); 这个类的对象
            Category category = new Category();
            // 给 category 这个对象赋值
            category.setId(setmeal.getCategoryId());
            // 根据categoryId 查询数据
            List<Category> categoryList = categoryMapper.selectBycategory(category);
            // 通过dtoList 类 给数据赋值
            setmealDto.setCategoryName(categoryList.get(0).getName());
            // 然后 根据
            setmealDto.setSetmealDishes(setmealDishMapper.selectByID(setmeal.getId()));
            return setmealDto;

        }).collect(Collectors.toList());
        dtoPageHeabl.setRecords(dtoList);
        return dtoPageHeabl;
    }

    /**
     * 根据用户的id 删除用户的数据
     *
     * @param ids 用户id
     * @return
     */
    @Override
    public Integer deleteByIdss(List<Long> ids) {
        for (Long id : ids) {
            setmealMapper.deleteByIds(id);
            setmealDishMapper.deleteByIds(id);
        }
        return null;
    }

    /**
     * 0 禁用 1启用
     *
     * @param status 状态
     * @param ids    用户id
     * @return 返回受影响的行数
     */
    @Override
    public Integer updateByIds(Integer status, Long[] ids) {
        return setmealMapper.updateByIds(status, ids);
    }


    /**
     * 用户id
     *
     * @param id 用户categoryId
     * @return 返回用户的对象信息
     */
    @Override
    public Setmeal selectById(Long id) {
        // 第一步：先把数据查询出来然后在编写
        Setmeal setmeal = setmealMapper.selectById(id);
        // 第二步：创建setmealDto类
        SetmealDto setmealDto = new SetmealDto();
        // 第三步：给这个类赋值
        BeanUtils.copyProperties(setmeal, setmealDto);
        // 第四步: 根据id 把另一张表中的数据查询出来
        setmealDto.setSetmealDishes(setmealDishMapper.selectByDishId(id));

        return setmealDto;
    }

    /**
     * 修改套餐数据
     *
     * @param setmealDto
     * @return
     */
    @Override
    public Integer update(HttpSession session, SetmealDto setmealDto) {
//        setmealDto.setCreateTime(new Date());
        setmealDto.setUpdateTime(new Date());
        setmealDto.setIsDeleted(1);
//        setmealDto.setCreateUser((Long) session.getAttribute("id"));
        setmealDto.setUpdateUser((Long) session.getAttribute("id"));
        // 把用户要修改的数据传入进去
        setmealMapper.updateSetmeal(setmealDto);

        // 再把套餐根据id给删除了
        Integer count = setmealDishMapper.deleteByIds(setmealDto.getId());
        // 使用for 循环给他赋值
        for (SetmealDish setmealDish : setmealDto.getSetmealDishes()) {
            setmealDish.setSetmealId(setmealDto.getId());
            setmealDish.setIsDeleted(1);
            setmealDish.setSort(0);
            setmealDish.setCreateTime(new Date());
            setmealDish.setUpdateTime(new Date());
            setmealDish.setCreateUser((Long) session.getAttribute("id"));
            setmealDish.setUpdateUser((Long) session.getAttribute("id"));
            // 给 dto 类进行赋值 把数据重新添加一次
            setmealDishMapper.insertAll(setmealDish);
        }
        return null;
    }


    /**
     * 单表的
     */
//    @Override
//    public List<Setmeal> list(Long categoryId, Integer status) {
//        return setmealMapper.list(categoryId,status);
//    }

    /**
     * 多表的查询
     * @param categoryId
     * @param status
     * @return
     */
    @Override
    public List<SetmealDto> list(Long categoryId, Integer status) {
        // 第一步：先把数据查询出来
        List<Setmeal> list = setmealMapper.list(categoryId, status);
        // 第二步：遍历list 集合
        List<SetmealDto> collect = list.stream().map((setmeal) -> {
            // 这里创建dto 类对象
            SetmealDto dto = new SetmealDto();
            BeanUtils.copyProperties(setmeal, dto);
            // 创建分类的对象
            Category category = new Category();
            // 第二步 获取categoryId
            category.setId(categoryId);
            Category category1 = categoryMapper.list(category).get(0);
            dto.setCategoryName(category1.getName());
            dto.setSetmealDishes(setmealDishMapper.selectByDishId(setmeal.getId()));
            return dto;
        }).collect(Collectors.toList());
        return collect;
    }

}
