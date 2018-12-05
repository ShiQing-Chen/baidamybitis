package com.chen.baida.model;

import java.util.Date;

/**
 * 主题反馈
 * @author HanHongmin 2018-11-12
 */
public class QrFeedback {
    /**
     * 非常好
     */
    public static final int OPT_GREAT = 1;
    /**
     * 满意
     */
    public static final int OPT_GOOD = 2;
    /**
     * 一般
     */
    public static final int OPT_NORMAL = 3;
    /**
     * 较差
     */
    public static final int OPT_NOT_GOOD = 4;
    /**
     * id
     */
    private String id;
    /**
     * 所属主题Id
     */
    private String topicId;
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
}
