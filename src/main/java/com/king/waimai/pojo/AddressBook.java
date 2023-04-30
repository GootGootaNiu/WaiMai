package com.king.waimai.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

// 收货地址
@Data
public class AddressBook {
    private Long id; // 主键
    private Long userId; // 用户id
    private String consignee;// 收货人
    private String sex; // 性别 0 女 1男
    private String phone; // 电话
    private String provinceCode;//省级区划编号
    private String provinceName; // 省级名称
    private String cityCode;// 市级划去编号
    private String cityName;// 市级名称
    private String districtCode; // 区级区划分编号
    private String districtName;// 区级区划编号
    private String detail;//详细地址
    private String label ; // 标签
    private String isDefault ; // 0默认  1 不是默认
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 修改时间
    private Long createUser; // 创建人
    private Long updateUser;  // 修改人
    private Integer isDeleted; // 0 删除
}
