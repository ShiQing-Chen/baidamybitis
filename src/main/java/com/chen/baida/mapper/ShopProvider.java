package com.chen.baida.mapper;

import com.chen.baida.vo.SearchShopParam;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ShiQing_Chen
 * @Description //TODO  生成动态sql
 * @date 2018/12/6 22:35
 */
public class ShopProvider {

    /**
     * 为Mapper 的listActivity 方法生成动态sql
     * @param params 页面传过来的参数
     * @return sql
     */
    @SuppressWarnings("unused")
    public String searchActivity(SearchShopParam params){
        String sql = "select * from shop s where s.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and s.shop_name like CONCAT('%',#{search},'%') ";
        }
        sql = sql + "order by create_time desc limit #{offset},#{limit} ";
        return sql;
    }

    @SuppressWarnings("unused")
    public String countActivity(SearchShopParam params){
        String sql = "select count(*) from shop s where s.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and s.shop_name like CONCAT('%',#{search},'%') ";
        }
        return sql;
    }
}
