package com.chen.baida.mapper;

import com.chen.baida.dto.Feedback;
import com.chen.baida.model.QrFeedback;
import com.chen.baida.vo.SearchFeedbackParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HanHongmin 2018-03-23
 * @since 0.0.1
 */
@Mapper
@Repository
public interface QrFeedbackMapper {

    @SelectProvider(type = QrFeedbackProvider.class, method = "searchFeedback")
    List<Feedback> searchFeedback(SearchFeedbackParam params);

    @SelectProvider(type = QrFeedbackProvider.class, method = "countFeedback")
    Long countFeedback(SearchFeedbackParam params);

    @Update(" update qr_feedback t set t.is_deleted = true where t.id = #{feedbackId}")
    int deleteFeedback(String feedbackId);

    @Insert("insert into qr_feedback(id, topic_id, feedback_option, suggestion, create_time, creator_id, is_deleted) values" +
            " (#{id},#{topicId}, #{feedbackOption}, #{suggestion}, #{createTime}, #{creatorId}, false)")
    int addFeedback(QrFeedback feedback);

    @Select(" select count(*) from qr_feedback t where t.is_deleted = false")
    Long countAll();
}
