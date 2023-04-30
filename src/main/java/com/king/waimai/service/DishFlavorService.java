package com.king.waimai.service;

import com.king.waimai.pojo.DishFlavor;

/**
 * 编写配置文件
 * extends IService<Category>
 */
public interface DishFlavorService {
    /**
     * 添加口味数据
     * @param dishFlavor 口味数据
     * @return 返回受影响的行数
     */
    Integer insertFlavor(DishFlavor dishFlavor);



}






















