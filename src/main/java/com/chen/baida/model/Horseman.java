package com.chen.baida.model;


import java.util.Date;

/**
 *
 * 骑手
 * @author ShiQing_Chen
 * @date 2018/12/4 14:24
 */
public class Horseman {

    /** 骑手id */
    private String id;

    /** 用户的唯一标识 */
    private String openid;

    /** 用户id */
    private String userId;

    /** 骑手名字 */
    private String manName;

    /** 骑手状态 0为休息 1为工作 默认为0 */
    private Integer manStatus;

    /** 骑手电话 */
    private String manPhone;

    /** 接单数量 */
    private Integer takeoutNum;

    /** 完成订单数量 */
    private Integer finishNum;

    /** 接单金额 */
    private Double manTakemoney;

    /** 完成订单金额 */
    private Double manFinishmoney;

    /** 骑手描述 */
    private Date manDesc;

    /** 登录用户名 */
    private String manUser;

    /** 登录密码 */
    private String manPassword;

    /** 创建人id */
    private String creatorId;

    /** 假删除 0未删除 1删除 */
    private Boolean isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

}
