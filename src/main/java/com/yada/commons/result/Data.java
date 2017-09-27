package com.yada.commons.result;

import java.util.List;

/**
 * 返回数据
 */
public class Data {

    private long total; // 总记录
    private List rows; //显示的记录

    public Data(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
