package com.king.waimai.pojo;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShoppingCart {
    private Long id; // 主键
    private String name; // 名称
    private String image;// 图片
    private Long userId;// 主键
    private Long dishId;//菜品id
    private Long setmealId;// 套餐id
    private String dishFlavor;// 口味
    private Integer number;// 数量
    private BigDecimal amount;// 金额
    private Date createTime;// 创建时间
}
