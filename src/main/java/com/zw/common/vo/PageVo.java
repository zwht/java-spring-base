package com.zw.common.vo;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhaowei on 2018/7/1.
 */
public class PageVo<T> {


    private Integer totalCount = 0;

    private List<T> pageData = new ArrayList<T>();

    public PageVo() {
    }

    public PageVo(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public PageVo(Integer totalCount, List<T> pageData) {
        this.totalCount = totalCount;
        this.pageData = pageData;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}