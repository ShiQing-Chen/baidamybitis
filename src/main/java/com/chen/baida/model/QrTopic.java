package com.chen.baida.model;

import java.util.Date;

/**
 * 活动主题
 * @author HanHongmin 2018-11-12
 */
public class QrTopic {

    /**
     * id
     */
    private String id;
    /**
     * 所属活动Id
     */
    private String actId;
    /**
     * 名称
     */
    private String topicName;

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

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 主讲人
     */
    private String speaker;

    /**
     * 主讲人简介
     */
    private String speakerIntro;

    /**
     * 地点，如：四楼会议厅
     */
    private String location;
    /**
     * 容量
     */
    private Integer capacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
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

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSpeakerIntro() {
        return speakerIntro;
    }

    public void setSpeakerIntro(String speakerIntro) {
        this.speakerIntro = speakerIntro;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
