package com.chen.baida.mapper;

import com.chen.baida.vo.SearchCheckInParam;
import org.apache.commons.lang3.StringUtils;

/**
 * 生成动态sql
 * @author HanHongmin 2018-11-26
 */
public class QrCheckInProvider {

    /**
     * 为Mapper 的listActivity 方法生成动态sql
     * @param params 页面传过来的参数
     * @return sql
     */
    @SuppressWarnings("unused")
    public String searchCheckIn(SearchCheckInParam params){
        String sql = "select t.*, u.name as user_name,u.mobile as user_mobile, u.sub_name, u.scho_name, a.id as act_id, a.act_name from qr_check_in t " +
                " left join user u on u.id = t.creator_id " +
                " left join qr_activity a on a.id = t.act_id " +
                " where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and u.name like CONCAT('%',#{search},'%') ";
        }
        sql = sql + "order by create_time desc limit #{offset},#{limit} ";
        return sql;
    }

    @SuppressWarnings("unused")
    public String countCheckIn(SearchCheckInParam params){
        String sql = "select count(*) from qr_check_in t " +
                " left join user u on u.id = t.creator_id " +
                " left join qr_activity a on a.id = t.act_id " +
                " where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and u.name like CONCAT('%',#{search},'%') ";
        }
        return sql;
    }
}
