package com.xuecheng.framework.model.response.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

/**
 * 分页
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/3/24
 */
public class QueryResult<T> {
    /**
     * 数据列表
     */
    private List<T> list;
    /**
     * 数据总数
     */
    private long total;


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QueryResult<?> that = (QueryResult<?>) o;
        return total == that.total &&
                Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, total);
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
