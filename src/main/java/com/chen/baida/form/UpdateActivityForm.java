package com.chen.baida.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author HanHongmin 2018-11-29
 */
public class UpdateActivityForm {
    private String id;
    /**
     * 名称
     */
    @Size(min=4,max = 20, message = "活动名称长度不符合要求，需要4-20个字")
    @NotEmpty(message = "活动名称不能为空")
    private String actName;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    /**
     * 活动地点
     */
    @Size(max = 30, message = "活动地点最多30个字")
    private String location;
    /**
     * 主办单位
     */
    @Size(max = 20, message = "主办单位最多20个字")
    private String organizer;
    /**
     * 协办单位，逗号分割
     */
    @Size(max = 50, message = "主办单位最多50个字")
    private String coOrganizer;
    /**
     * 指导单位，逗号分割
     */
    @Size(max = 20, message = "主办单位最多20个字")
    private String leaderOrganizer;

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
