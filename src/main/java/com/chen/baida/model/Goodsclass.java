package com.chen.baida.model;

import java.util.Date;

/**
 *
 * 菜单类别表
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */
public class Goodsclass {

    /** 菜单类别id */
    private String id;

    /** 店铺id */
    private String shopId;

    /** 类型名称 */
    private String className;

    /** 类别状态  1为使用 0为不使用 默认1*/
    private Integer classStatus;

    /** 类别顺序 */
    private Integer classNum;

    /** 类别描述 */
    private String classDesc;

    /** 创建人id */
    private String creatorId;

    /** 假删除 0未删除 1删除 */
    private Boolean isDeleted;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;


}
