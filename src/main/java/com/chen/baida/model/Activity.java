package com.chen.baida.model;

import java.util.Date;


/**
 *
 * 活动
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */
public class Activity {


    /** 活动id */
    private String id;

    /** 店铺id */
    private String shopId;

    /** 活动类型 0为平台活动 1位商铺活动 默认0*/
    private Integer activityType;

    /** 活动标题 */
    private String activityTitle;

    /** 活动状态  1为上线 0位失效 默认0*/
    private Integer activityStatus;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 活动描述 */
    private String activityDesc;

    /** 活动logo */
    private String activityPath;

    /** 创建人id */
    private String creatorId;

    /** 假删除 0未删除 1删除 */
    private Boolean isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}
