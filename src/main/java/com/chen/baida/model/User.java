package com.chen.baida.model;

import java.util.Date;


/**
 *
 * 用户
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */
public class User {

    /**
     * 未知或开放用户
     */
    public static final int ROLE_ID_UNKNOW = 1;
    /**
     * 骑手
     */
    public static final int ROLE_ID_HORSE = 2;
    /**
     * 管理员
     */
    public static final int ROLE_ID_ADMIN = 3;

    /** 用户id */
    private String id;

    /** 登录名 */
    private String loginUser;

    /** 登录密码 */
    private String loginPassword;

    /** 角色 */
    private Integer roleId;

    /** 用户的唯一标识 */
    private String openid;

    /** 用户昵称 */
    private String nickname;

    /** 用户性别, 1为男性 2为女性 0为未知 */
    private Integer sex;

    /** 省份 */
    private String province;

    /** 城市 */
    private String city;

    /** 国家 CN为中国 */
    private String country;

    /** 用户头像 */
    private String headimgurl;

    /** 用户特权信息 json数组 */
    private String privilege;

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

    /** 最后登录ip */
    private String lastLoginIp;

    /** 最后登录时间 */
    private Date lastLoginTime;

    /** 假删除 0未删除 1删除 */
    private Boolean isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

}
