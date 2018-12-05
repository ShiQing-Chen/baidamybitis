package com.chen.baida.model;

import java.util.Date;

/**
 * 会议活动
 * @author HanHongmin 2018-11-12
 */
public class QrActivity {

    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String actName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 主办单位
     */
    private String organizer;
    /**
     * 协办单位，逗号分割
     */
    private String coOrganizer;
    /**
     * 指导单位，逗号分割
     */
    private String leaderOrganizer;

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

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getCoOrganizer() {
        return coOrganizer;
    }

    public void setCoOrganizer(String coOrganizer) {
        this.coOrganizer = coOrganizer;
    }

    public String getLeaderOrganizer() {
        return leaderOrganizer;
    }

    public void setLeaderOrganizer(String leaderOrganizer) {
        this.leaderOrganizer = leaderOrganizer;
    }
}
