package com.chen.baida.form;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ShiQing_Chen
 * @date 2018/12/7 11:36
 */

public class AddShopForm {
    /** 店铺id */
    private String id;

    /** 店铺名字 */
    private String shopName;

    /** 店铺地址 */
    private String shopAddress;

    /** 店铺log */
    private String shopPath;

    /** 店铺状态  1为上线 0为下线 默认0*/
    private Integer shopStatus;

    /** 店铺描述 */
    private String shopDesc;

    /** 店铺电话 */
    private String shopPhone;

    /** 起送费 */
    private Double startFee;

    /** 营业开始时间 */
    private Date startTime;

    /** 营业结束时间 */
    private Date endTime;

    /** 店铺活动 */
    private String shopActivity;

    /** 店铺热度 */
    private Integer shopHeat;

    /** 店铺地址经度 */
    private BigDecimal longitude;

    /** 店铺地址纬度 */
    private BigDecimal latitude;

    /** 假删除 0未删除 1删除 */
    private String isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;
}
