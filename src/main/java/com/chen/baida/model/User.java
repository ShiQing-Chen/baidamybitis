package com.chen.baida.model;

import java.util.Date;


/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */


/** 用户 */
public class User {

    /** 用户id */
    private String id;

    /** 用户的唯一标识 */
    private String openid;

    /** UnionID机制 */
    private String unionid;

    /** 地址id//暂时不用 */
    private String addressId;

    /** 用户名称 */
    private String userName;

    /** 用户电话 */
    private String userPhone;

    /** 用户地址 */
    private String userAddress;

    /** 用户状态  0为禁用 1为正常 默认1*/
    private Integer userStatus;

    /** 用户描述 */
    private String userDesc;

    /** 假删除 0未删除 1删除 */
    private String isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

}
