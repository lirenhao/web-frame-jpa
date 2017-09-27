package com.yada.commons.base;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public abstract class BaseQuery<T> implements Specification<T> {

    private int page = 1; // 当前页数
    private int rows = 20; // 每页显示的记录数
    private String sort; // 排序字段
    private String order = "asc"; // asc，desc mybatis Order 关键字

    public int getPage() {
        return page - 1;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Sort.Direction getOrder() {
        return "asc".equals(order) ? Sort.Direction.ASC : Sort.Direction.DESC;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
