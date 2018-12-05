package com.chen.baida.mapper;

import com.chen.baida.vo.SearchTopicParam;
import org.apache.commons.lang3.StringUtils;

/**
 * 生成动态sql
 * @author HanHongmin 2018-11-26
 */
public class QrTopicProvider {

    @SuppressWarnings("unused")
    public String searchTopic(SearchTopicParam params){
        String sql = "select t.*,a.act_name from qr_topic t left join qr_activity a on a.ID = t.act_id " +
                " where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and t.topic_name like CONCAT('%',#{search},'%') ";
        }
        sql = sql + "order by create_time desc limit #{offset},#{limit} ";
        return sql;
    }

    @SuppressWarnings("unused")
    public String countTopic(SearchTopicParam params){
        String sql = "select count(*) from qr_topic t where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and t.topic_name like CONCAT('%',#{search},'%') ";
        }
        return sql;
    }
}
