package com.king.waimai.pojo;

import lombok.Data;

/**
 * 验证码登录
 */
@Data
public class User {
    private Long id; // 主键
    private String name; // 姓名
    private String phone; // 电话
    private String sex; // 性别
    private String idNumber; // 身份证号
    private String avatar; // 头像
    private Integer status; // 状态 0禁用 1 正常
}
