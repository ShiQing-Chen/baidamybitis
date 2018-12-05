package com.chen.baida.model;

import java.util.Date;

/**
 * @author HanHongmin 2018-11-12
 */
public class User {
    /**
     * 未知或开放用户
     */
    public static final int ROLE_ID_UNKNOW = -1;
    /**
     * 管理员
     */
    public static final int ROLE_ID_ADMIN = 1;

    /**
     * 用户id
     */
    private String id;
    /**
     * 用户手机号码
     */
    private String mobile;
    /**
     * 非明文密码
     */
    private String password;
    /**
     * 用户的名字、昵称
     */
    private String name;

    /**
     * 学科名称
     */
    private String subName;

    /**
     * 学校名称
     */
    private String schoName;
    /**
     * 角色
     */
    private Integer roleId = ROLE_ID_UNKNOW;


    /**
     * 帐号创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSchoName() {
        return schoName;
    }

    public void setSchoName(String schoName) {
        this.schoName = schoName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
