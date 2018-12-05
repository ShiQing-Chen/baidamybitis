package com.chen.baida.mapper;

import com.chen.baida.dto.Topic;
import com.chen.baida.form.UpdateTopicForm;
import com.chen.baida.model.QrTopic;
import com.chen.baida.vo.SearchTopicParam;
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
public interface QrTopicMapper {

    @SelectProvider(type = QrTopicProvider.class, method = "searchTopic")
    List<Topic> searchTopic(SearchTopicParam params);

    @SelectProvider(type = QrTopicProvider.class, method = "countTopic")
    Long countTopic(SearchTopicParam params);

    @Update(" update qr_topic t set t.is_deleted = true where t.id = #{topicId}")
    int deleteTopic(String topicId);

    @Insert(" insert into qr_topic(id, act_id, topic_name, create_time, creator_id, is_deleted, start_time, end_time," +
            " speaker, speaker_intro, location, capacity) values" +
            " (#{id}, #{actId}, #{topicName}, #{createTime}, #{creatorId}, false, #{startTime}, #{endTime}," +
            " #{speaker}, #{speakerIntro}, #{location}, #{capacity})")
    int addTopic(QrTopic topic);

    @Select(" select * from qr_topic t where t.id = #{topicId}")
    QrTopic getById(String topicId);

    @Select(" select t.*,a.id as act_id,a.act_name from qr_topic t left join qr_activity a on a.id = t.act_id where t.id = #{topicId}")
    UpdateTopicForm getUpdateFormById(String topicId);

    @Update(" update qr_topic t " +
            " set t.act_id = #{actId}, " +
            " t.start_time = #{startTime}, " +
            " t.end_time = #{endTime}, " +
            " t.speaker = #{speaker}, " +
            " t.speaker_intro = #{speakerIntro}, " +
            " t.location = #{location}, " +
            " t.capacity = #{capacity}, " +
            " t.topic_name = #{topicName} " +
            " where t.id = #{id}")
    int updateTopic(QrTopic topic);

    @Select(" select count(*) from qr_topic t where t.is_deleted = false")
    Long countAll();

    /**
     * 已错过的
     */
    @Select("select t.* from qr_topic t " +
            " where t.act_id = #{actId} " +
            " and t.is_deleted = false " +
            " and t.start_time < #{now}" +
            " order by t.start_time ")
    List<Topic> listPassedTopic(@Param("actId") String actId, @Param("now") Date now);

    /**
     * 今天还未开始的
     */
    @Select("select t.* from qr_topic t " +
            " where t.act_id = #{actId} " +
            " and t.is_deleted = false " +
            " and t.start_time >= #{now}" +
            " and t.start_time < #{tomorrow}" +
            " order by t.start_time ")
    List<Topic> listUnPassedToday(@Param("actId") String actId, @Param("now") Date now, @Param("tomorrow") Date tomorrow);

    /**
     * 未来几天的
     */
    @Select("select t.* from qr_topic t " +
            " where t.act_id = #{actId} " +
            " and t.is_deleted = false " +
            " and t.start_time >= #{tomorrow}" +
            " order by t.start_time ")
    List<Topic> listComingDays(@Param("actId") String actId, @Param("tomorrow") Date tomorrow);
}
