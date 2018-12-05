package com.chen.baida.mapper;

import com.chen.baida.vo.SearchFeedbackParam;
import org.apache.commons.lang3.StringUtils;

/**
 * 生成动态sql
 * @author HanHongmin 2018-11-26
 */
public class QrFeedbackProvider {

    /**
     * 为Mapper 的listActivity 方法生成动态sql
     * @param params 页面传过来的参数
     * @return sql
     */
    @SuppressWarnings("unused")
    public String searchFeedback(SearchFeedbackParam params){
        String sql = "select t.*,p.topic_name,p.act_id,a.act_name," +
                " u.id as user_id," +
                " u.name as user_name," +
                " u.mobile as user_mobile," +
                " u.scho_name as user_scho_name," +
                " u.sub_name as user_sub_name " +
                " from qr_feedback t " +
                " left join qr_topic p on p.id = t.topic_id " +
                " left join qr_activity a on a.id = p.act_id " +
                " left join user u on t.creator_id = u.id" +
                " where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and t.suggestion like CONCAT('%',#{search},'%') ";
        }
        sql = sql + "order by create_time desc limit #{offset},#{limit} ";
        return sql;
    }

    @SuppressWarnings("unused")
    public String countFeedback(SearchFeedbackParam params){
        String sql = "select count(*) from qr_feedback t where t.is_deleted = false ";
        if(StringUtils.isNotBlank(params.getSearch())){
            sql = sql + " and t.suggestion like CONCAT('%',#{search},'%') ";
        }
        return sql;
    }
}
