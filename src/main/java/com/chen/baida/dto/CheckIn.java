package com.chen.baida.dto;

import java.util.Date;

/**
 * 会议签到
 * @author HanHongmin 2018-11-12
 */
public class CheckIn {

    /**
     * id
     */
    private String id;
    /**
     * 所属活动Id
     */
    private String actId;

    private String actName;

    private String userName;

    /**
     * 用户手机号码
     */
    private String userMobile;

    /**
     * 学科名称
     */
    private String subName;

    /**
     * 学校名称
     */
    private String schoName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private String creatorId;

    /**
     * 删除位
     */
    private Boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
