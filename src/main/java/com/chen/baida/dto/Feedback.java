package com.chen.baida.dto;

import java.util.Date;

/**
 * 主题反馈
 *
 * @author HanHongmin 2018-11-12
 */
public class Feedback {

    /**
     * id
     */
    private String id;
    /**
     * 所属主题Id
     */
    private String topicId;
    /**
     * 主题名称
     */
    private String topicName;
    /**
     * 活动Id
     */
    private String actId;
    /**
     * 活动名称
     */
    private String actName;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userMobile;

    /**
     * 用户学校名称
     */
    private String userSchoName;

    /**
     * 用户学科
     */
    private String userSubName;
    /**
     * 评价，见常量
     */
    private Integer feedbackOption;

    /**
     * 建议文本
     */
    private String suggestion;

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

    public Integer getFeedbackOption() {
        return feedbackOption;
    }

    public void setFeedbackOption(Integer feedbackOption) {
        this.feedbackOption = feedbackOption;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserSchoName() {
        return userSchoName;
    }

    public void setUserSchoName(String userSchoName) {
        this.userSchoName = userSchoName;
    }

    public String getUserSubName() {
        return userSubName;
    }

    public void setUserSubName(String userSubName) {
        this.userSubName = userSubName;
    }
}
