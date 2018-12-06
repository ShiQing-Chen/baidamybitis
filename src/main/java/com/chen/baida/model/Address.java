package com.chen.baida.model;


import java.util.Date;


/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */


/** 地址 */
public class Address {

    /** 地址id */
    private String id;

    /** 用户id */
    private String userId;

    /** 订单id */
    private String orderId;

    /** 省 */
    private String addressProvince;

    /** 市 */
    private String addressCity;

    /** 区/县 */
    private String addressXian;

    /** 街道 */
    private String addresssTreet;

    /** 详细 */
    private String addresssDetail;

    /** 经度 */
    private String longitude;

    /** 纬度 */
    private String latitude;

    /** 假删除 0未删除 1删除 */
    private String isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}