package com.chen.baida.model;

import java.util.Date;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */


/** 订单详情 */
public class Orderitem {

    /** 订单详情id */
    private String id;

    /** 订单id */
    private String orderId;

    /** 商品id */
    private String goodsId;

    /** 商品数量 */
    private Integer goodsNum;

    /** 商品实际价格 */
    private Double goodsPrice;

    /** 假删除 0未删除 1删除 */
    private String isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}
