package com.king.waimai.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 套餐表
 */
@Data
public class Setmeal {
    //   private static final long serialVersionUID = 1L;
    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.NONE)
    private Long id; // 主键
    private Long categoryId;// 菜品分类id
    private String name; // 套餐名称
    private double price; // 套餐价格
    private Integer status;// 状态0 停用 1启用
    private String code; // 编码
    private String description; // 描述信息
    private String image;// 图片
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 修改时间
    private Long createUser; // 创建人
    private Long updateUser;  // 修改人
    private Integer isDeleted; //0 表示删除 1表示没有删除
}
