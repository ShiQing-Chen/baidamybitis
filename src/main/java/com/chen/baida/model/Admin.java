package com.chen.baida.model;


import java.util.Date;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:53
 */

/** 管理员 */
public class Admin {

    /** 管理员id */
    private String id;

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

    /** 假删除 0未删除 1删除 */
    private String isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}
