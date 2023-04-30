package com.king.waimai.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;


/**
 * 菜品口味类
 */
@Data
public class DishFlavor extends Dish {
    private static final long serialVersionUID = 1L;
    private Long id;// 主键

    private Long dishId; // 菜品
    private String name; // 口味名称
    private String value; // 口味数据 list
    private Integer isDelete; // 0 删除了 1 没有删除
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 修改时间
    private Long createUser; // 创建人
    private Long updateUser;  // 修改人
}
