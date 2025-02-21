package com.company.utils;

public class PageInfo {

    //当前页数
    private Integer page=1;

    //分页大小
    private Integer limit=2;

    //开始序号
    private Integer startIndex;

    /**
     * 计算开始序号
     * @return
     */
    public Integer getStartIndex() {

        this.startIndex=(this.page-1)*limit;

        return startIndex;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}