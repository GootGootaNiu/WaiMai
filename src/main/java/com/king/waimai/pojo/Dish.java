package com.king.waimai.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 菜品管理
 */
@Data
public class Dish extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;// 注解
    private String name; // 菜品名称
    private Long categoryId;// 菜品分类id  dish/list?categoryI
    private BigDecimal price; // 菜品价格
    private String code; // 商品码
    private Integer sort;
    private String image; // 图片
    private String description; // 描述信息
    private Integer status;// 0停售  1起售
    private Integer isDeleted; // 是否删除 0 删除了 1 没有删除


    //    Long id;
//    String name;
//    Long categoryId;
//    BigDecimal price;
//    String code;
//    String image;
//    String description;
//    int status;
//    int sort;
//    int isDeleted;
}































