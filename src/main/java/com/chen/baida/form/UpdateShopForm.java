package com.chen.baida.form;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ShiQing_Chen
 * @date 2018/12/7 11:36
 */

public class UpdateShopForm {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPath() {
        return shopPath;
    }

    public void setShopPath(String shopPath) {
        this.shopPath = shopPath;
    }

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public Double getStartFee() {
        return startFee;
    }

    public void setStartFee(Double startFee) {
        this.startFee = startFee;
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

    public String getShopActivity() {
        return shopActivity;
    }

    public void setShopActivity(String shopActivity) {
        this.shopActivity = shopActivity;
    }

    public Integer getShopHeat() {
        return shopHeat;
    }

    public void setShopHeat(Integer shopHeat) {
        this.shopHeat = shopHeat;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
