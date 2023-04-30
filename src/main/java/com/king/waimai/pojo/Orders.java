package com.king.waimai.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 */
@Data
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; // 主键
    private String number; // 订单号
    private Integer status; // 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
    private Long userId; // 下单用户
    private Long addressBookId;// 地址id

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime; //下单时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkoutTime; // 结账时间

    private Integer payMethod; // 支付方式 1，微信 2 支付宝
    private Double amount; // 实收金额
    private String remark; // 备注
    private String phone; // 电话
    private String address; // 写收信人 收获地址
    private String userName; // 用户名
    private String consignee; // 收件人
}
