package com.king.waimai.common;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装结果集返回给前端数据
 * 通用返回结果  服务端响应的数据最终都会封装成此对象
 *
 * @param <T>
 */
@Data
public class R<T> {

    private Integer code; // 编码 1成功 0和其他都是失败
    private String msg; // 错误信息
    private T data; // 泛型 可以传入任何类型的数据
    private Map map = new HashMap();  // 动态数据

    /**
     * 当我们响应成功的时候返回的是 R对象
     *
     * @param object 用户的数据
     * @param <T>    返回的类型
     * @return 返回1成功  其他失败
     */
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    /**
     * 当我们失败了 就需要把这个给传入进去
     *
     * @param msg 登录失败就
     * @param <T> 通用的返回结果
     * @return 返回值
     */
    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }


    /**
     * 返回数据
     * @param key 键值
     * @param value 用户数据
     * @return 返回结束
     */
    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}















