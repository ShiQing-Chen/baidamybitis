package com.chen.baida.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author HanHongmin 2018-11-29
 */
public class UserInfoForm {
    @Size(max = 20, message = "学校名称太长，最多20个汉字")
    private String schoName;
    @Size(max = 10, message = "学科名称太长，最多10个汉字")
    private String subName;
    @Size(max = 10, message = "姓名太长，最多10个汉字")
    private String name;
    @Size(max = 11, message = "手机号码太长，最多11个数字")
    @NotEmpty(message = "请填写手机号码，应为11位数字")
    private String mobile;
    private String r;

    public String getSchoName() {
        return schoName;
    }

    public void setSchoName(String schoName) {
        this.schoName = schoName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }
}
