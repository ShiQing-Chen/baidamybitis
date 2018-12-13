package com.chen.baida.model;

import java.util.Date;


/**
 *
 * 订单
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */
public class Order {

    /** 订单id */
    private String id;

    /** 用户id */
    private String userId;

    /** 骑手id */
    private String manId;

    /** 地址id */
    private String addressId;

    /** 订单TITLE */
    private String orderName;

    /** 下单时间 */
    private Date placeTime;

    /** 接单时间 */
    private Date takingTime;

    /** 完成时间 */
    private Date finishTime;

    /** 订单类型 1为加急 0为一般 默认为0 */
    private Integer orderType;

    /** 订单状态 0为 待接单 1为已接单，正在派送 2位已送达 默认为0 */
    private Integer orderStatus;

    /** 收货人信息 */
    private String receiverInfo;

    /** 收货人电话 */
    private String receiverPhone;

    /** 收货地址 */
    private String orderAddress;

    /** 订单金额 */
    private Double orderTotal;

    /** 实际金额 */
    private Double realTotal;

    /** 支付方式 0为微信 1为支付宝 2为货到付款 默认为0 */
    private Integer payWay;

    /** 是否打折 1为是 0为否 默认为0 */
    private Integer orderIsdiscount;

    /** 折扣 默认为0*/
    private Double orderDiscount;

    /** 配送费 */
    private Double sendCost;

    /** 餐盒费 */
    private Double boxCost;

    /** 备注 */
    private String orderDesc;

    /** 订单说明 */
    private String orderText;

    /** 创建人id */
    private String creatorId;

    /** 假删除 0未删除 1删除 */
    private Boolean isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}
