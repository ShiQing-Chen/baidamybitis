package com.chen.baida.session;

import java.util.Objects;

/**
 * 共享用户用的，存放在session-redis 中的对象<br/>
 * 注意：和ecourse 的不一样
 * @author HanHongmin 2017-11-01
 */
public class SharedUser {


    /**
     * 用户id
     */
    private String id;
    /**
     * 用户的名字、昵称
     */
    private String name;
    /**
     * 角色
     */
    private Integer roleId;
    /**
     * 用户手机号码
     */
    private String mobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SharedUser)){
            return false;
        }

        SharedUser that = (SharedUser) o;

        return getId() != null && Objects.equals(getId(),that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
