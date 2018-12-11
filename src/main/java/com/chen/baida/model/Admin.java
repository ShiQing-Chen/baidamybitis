package com.chen.baida.model;


import java.util.Date;

/**
 *
 * 管理员
 * @author ShiQing_Chen
 * @date 2018/12/3 17:53
 */
public class Admin {

    /** 管理员id */
    private String id;

    /** 用户的唯一标识 */
    private String openid;

    /** 用户id */
    private String userId;

    /** 管理员名称 */
    private String adminName;

    /** 管理员登录密码 */
    private String adminPassword;

    /** 管理员电话 */
    private String adminPhone;

    /** 管理员状态 0为禁用 1为正常 默认为1 */
    private Integer adminStatus;

    /** 管理员描述 */
    private String adminDesc;

    /** 创建人id */
    private String creatorId;

    /** 假删除 0未删除 1删除 */
    private String isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}
