package com.king.waimai.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 */
@Data
public class Employee  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;  // 用户id
    private String name; // 姓名
    private String username; // 用户名
    private String password; // 密码
    private String phone; // 手机号
    private String sex; // 性别
    private String idNumber; // 身份证号
    private Integer status;// 状态 0 禁用 1 正常

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee(Date createTime, Date updateTime, Long createUser, Long updateUser, Long id, String name, String username, String password, String phone, String sex, String idNumber, Integer status) {
        super(createTime, updateTime, createUser, updateUser);
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.idNumber = idNumber;
        this.status = status;
    }
}
