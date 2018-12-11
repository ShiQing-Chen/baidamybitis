package com.chen.baida.model;

import java.util.Date;


/**
 *
 * 商品
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */
public class Goods {

    /** 商品id */
    private String id;

    /** 店铺id */
    private String shopId;

    /** 类别id */
    private String classId;

    /** 商品名字 */
    private String goodsName;

    /** 商品价格 */
    private Double goodsPrice;

    /** 商品状态  1为上架 0为下架 默认1*/
    private Integer goodsStatus;

    /** 商品描述 */
    private String goodsDesc;

    /** 商品热度 */
    private Integer goodsHeat;

    /** 商品logo */
    private String goodsPath;

    /** 是否打折  1为是 0为否 默认0*/
    private Integer isDiscount;

    /** 折扣 折扣 默认为1 不打折*/
    private Double goodsDiscount;

    /** 创建人id */
    private String creatorId;

    /** 假删除 0未删除 1删除 */
    private String isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}
