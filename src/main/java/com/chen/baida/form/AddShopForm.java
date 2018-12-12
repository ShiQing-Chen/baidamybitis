package com.chen.baida.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ShiQing_Chen
 * @date 2018/12/7 11:36
 */

public class AddShopForm {

    /** 店铺名字 */
    @Size(min=4,max = 20, message = "店铺名字长度不符合要求，需要2-20个字!")
    @NotEmpty(message = "店铺名字不能为空!")
    private String shopName;

    /** 店铺地址 */
    @Size(max = 30, message = "店铺地址长度不符合要求，不能超过30个字!")
    private String shopAddress;

    /** 店铺log */
    private String shopPath;

    /** 店铺状态  1为上线 0为下线 默认0*/
    private Integer shopStatus;

    /** 店铺描述 */
    @Size(max = 350, message = "店铺地址长度不符合要求，不能超过350个字!")
    private String shopDesc;

    /** 店铺电话 */
    @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}", message = "手机号码格式不正确!")
    @Size(min = 11, max = 11, message = "手机号码格式不正确!")
    private String shopPhone;

    /** 起送费 */
    @Digits(integer = 3, fraction = 2, message = "启动费不符合要求!")
    private Double startFee;

    /** 营业开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    /** 营业结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    /** 店铺活动 */
    @Size(max = 450, message = "店铺活动长度不符合要求，不能超过450个字!")
    private String shopActivity;

    /** 店铺地址经度 */
    @Digits(integer = 3, fraction = 6, message = "经度不符合要求!")
    private BigDecimal longitude;

    /** 店铺地址纬度 */
    @Digits(integer = 2, fraction = 6, message = "纬度不符合要求!")
    private BigDecimal latitude;

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
}
