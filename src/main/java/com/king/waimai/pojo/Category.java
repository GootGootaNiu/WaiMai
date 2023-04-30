package com.king.waimai.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 分类
 */

@Data
public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; // 分类id
    private Integer type; // 1 菜品分类 2套餐分类
    private String name;  // 分类名称
    private Integer sort; // 顺序

    public Category() {
    }



    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(type, category.type) && Objects.equals(name, category.name) && Objects.equals(sort, category.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, type, name, sort);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Category(Date createTime, Date updateTime, Long createUser, Long updateUser, Long id, Integer type, String name, Integer sort) {
        super(createTime, updateTime, createUser, updateUser);
        this.id = id;
        this.type = type;
        this.name = name;
        this.sort = sort;
    }
}
