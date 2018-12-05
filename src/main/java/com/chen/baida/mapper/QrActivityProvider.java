package com.chen.baida.mapper;

import com.chen.baida.vo.SearchActivityParam;
import org.apache.commons.lang3.StringUtils;

/**
 * 生成动态sql
 * @author HanHongmin 2018-11-26
 */
public class QrActivityProvider {

    /**
     * 为Mapper 的listActivity 方法生成动态sql
     * @param params 页面传过来的参数
     * @return sql
     */
    @SuppressWarnings("unused")
    public String searchActivity(SearchActivityParam params){
        String sql = "select * from qr_activity t where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and t.act_name like CONCAT('%',#{search},'%') ";
        }
        sql = sql + "order by create_time desc limit #{offset},#{limit} ";
        return sql;
    }

    @SuppressWarnings("unused")
    public String countActivity(SearchActivityParam params){
        String sql = "select count(*) from qr_activity t where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and t.act_name like CONCAT('%',#{search},'%') ";
        }
        return sql;
    }
}
