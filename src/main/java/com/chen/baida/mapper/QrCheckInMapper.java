package com.chen.baida.mapper;

import com.chen.baida.dto.CheckIn;
import com.chen.baida.model.QrCheckIn;
import com.chen.baida.vo.SearchCheckInParam;
import com.chen.baida.vo.StringLongVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author HanHongmin 2018-03-23
 * @since 0.0.1
 */
@Mapper
@Repository
public interface QrCheckInMapper {

    @SelectProvider(type = QrCheckInProvider.class, method = "searchCheckIn")
    List<CheckIn> searchCheckIn(SearchCheckInParam params);

    @SelectProvider(type = QrCheckInProvider.class, method = "countCheckIn")
    Long countCheckIn(SearchCheckInParam params);

    @Select(" select count(*) from qr_check_in t where t.is_deleted = false")
    Long countAll();

    @Select(" select count(*) from qr_check_in t where t.is_deleted = false and t.create_time >= #{createTime}")
    Long countTodayCheckIn(Date createTime);

    @Insert(" insert into qr_check_in(id, act_id, create_time, creator_id, is_deleted) values" +
            " (#{id}, #{actId}, #{createTime}, #{creatorId}, false)")
    int addTopic(QrCheckIn checkIn);

    @Select(" select * from qr_check_in t where t.act_id = #{actId} and t.creator_id = #{userId}")
    QrCheckIn getCheckInByUserAndActId(@Param("userId") String userId, @Param("actId") String actId);

    @Select(" select count(*) from qr_check_in t where t.is_deleted = false and t.create_time < #{dateTime}")
    Long countBeforeTime(Date dateTime);

    /**
     * 习惯上整点统计，如8点20来的，算到9点之前的分组里，所以用了+1
     * @param dateTime 大于某个时间点的数据
     * @return 统计数据
     */
    @Select(" select count(*) as `num`," +
            " hour(t.create_time)+1 as `key` " +
            " from qr_check_in t where t.is_deleted = false " +
            " and t.create_time >= #{dateTime}" +
            " group by hour(t.create_time)+1 ")
    List<StringLongVo> groupByHourAfterTime(Date dateTime);
}
