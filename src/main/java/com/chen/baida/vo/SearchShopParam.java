package com.chen.baida.vo;

/**
 * @author ShiQing_Chen
 * @date 2018/12/7 11:22
 */

public class SearchShopParam {
    private String sort;
    private String order;
    private Integer offset;
    private Integer limit;

    private String search;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "SearchShopParam{" +
                "sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", offset=" + offset +
                ", limit=" + limit +
                ", search='" + search + '\'' +
                '}';
    }
}
