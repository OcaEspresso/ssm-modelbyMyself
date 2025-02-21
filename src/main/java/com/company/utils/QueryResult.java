package com.company.utils;

import java.util.List;

public class QueryResult<T> {

    //页面数据
    private List<T> data;

    //总记录数
    private Long count;


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}