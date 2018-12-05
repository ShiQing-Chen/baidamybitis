package com.chen.baida.mapper;

import com.chen.baida.form.UpdateActivityForm;
import com.chen.baida.model.QrActivity;
import com.chen.baida.vo.SearchActivityParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HanHongmin 2018-03-23
 * @since 0.0.1
 */
@Mapper
@Repository
public interface QrActivityMapper {

    @SelectProvider(type = QrActivityProvider.class, method = "searchActivity")
    List<QrActivity> searchActivity(SearchActivityParam params);

    @SelectProvider(type = QrActivityProvider.class, method = "countActivity")
    Long countActivity(SearchActivityParam params);

    @Update(" update qr_activity t set t.is_deleted = true where t.id = #{activityId}")
    int deleteActivity(String activityId);

    @Insert(" insert into qr_activity(id, act_name, create_time, creator_id, is_deleted, start_time, end_time," +
            " location, organizer, co_organizer, leader_organizer) values" +
            " (#{id}, #{actName}, #{createTime}, #{creatorId}, false, #{startTime}, #{endTime}," +
            " #{location}, #{organizer}, #{coOrganizer}, #{leaderOrganizer})")
    int addActivity(QrActivity activity);

    @Select(" select * from qr_activity t where t.id = #{actId}")
    QrActivity getById(String actId);

    @Select(" select t.* from qr_activity t where t.id = #{activityId}")
    UpdateActivityForm getUpdateFormById(String activityId);

    @Update(" update qr_activity t " +
            " set t.act_name = #{actName}, " +
            " t.start_time = #{startTime}, " +
            " t.end_time = #{endTime}, " +
            " t.location = #{location}, " +
            " t.organizer = #{organizer}, " +
            " t.co_organizer = #{coOrganizer}, " +
            " t.leader_organizer = #{leaderOrganizer} " +
            " where t.id = #{id}")
    int updateActivity(QrActivity activity);
}
