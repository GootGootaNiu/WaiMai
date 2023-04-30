package com.king.waimai.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
// 分页
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHeabl<T> {

    protected List<T> records = Collections.emptyList();
    /**
     * 总数
     */
    protected long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    protected long page = 10;
    /**
     * 当前页
     */
    protected long pageSize = 1;

}
