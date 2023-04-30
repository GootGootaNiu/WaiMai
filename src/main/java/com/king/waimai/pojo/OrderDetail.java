package com.king.waimai.pojo;

import cn.hutool.log.Log;
import lombok.Data;
import sun.tracing.dtrace.DTraceProviderFactory;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表明细表
 */
@Data
public class OrderDetail implements Serializable {
//    private static final long serialVersionUID = 1L;
    private static final long serialVersionUID = 1L;
    private Long id; // 主键
    private String name; // 名字
    private String image; // 图片
    private Long orderId;// 订单id
    private Long dishId; // 菜品id
    private Long setmealId; // 套餐id
    private String dishFlavor; // 口味
    private Integer number; // 数量
    private double amount; // 金额
}
