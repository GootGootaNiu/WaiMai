package com.king.waimai.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 套餐菜品关系
 */
@Data
public class SetmealDish {
    @TableId(value = "id",type = IdType.NONE)
    private Long id; // 主键
    private Long setmealId;// 套餐id
    private Long dishId;// 菜品id
    private String name ; // 菜品名称
    private double price; // 菜品原价
    private Integer copies ; // 份数
    private Integer sort; // 排序
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 修改时间
    private Long createUser; // 创建人
    private Long updateUser;  // 修改人
    private Integer isDeleted; //0 表示删除 1表示没有删除
}
