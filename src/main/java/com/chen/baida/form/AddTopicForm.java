package com.chen.baida.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author HanHongmin 2018-11-29
 */
public class AddTopicForm {

    @NotEmpty(message = "请选择一个活动")
    private String actId;
    /**
     * 选择的活动名称
     */
    private String actName;
    /**
     * 名称
     */
    @Size(min=4,max = 40, message = "长度不符合要求，需要4-40个字")
    @NotEmpty(message = "不能为空")
    private String topicName;

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
    @Size(max = 30, message = "地点最多30个字")
    private String location;
    /**
     * 主讲嘉宾
     */
    @Size(max = 50, message = "主办单位最多50个字")
    private String speaker;
    /**
     * 嘉宾介绍
     */
    @Size(max = 500, message = "主办单位最多500个字")
    private String speakerIntro;
    /**
     * 指导单位，逗号分割
     */
    private Integer capacity;

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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
