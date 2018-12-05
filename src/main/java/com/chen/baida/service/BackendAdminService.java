package com.chen.baida.service;

import com.chen.baida.dto.CheckIn;
import com.chen.baida.dto.Feedback;
import com.chen.baida.dto.Topic;
import com.chen.baida.form.AddActivityForm;
import com.chen.baida.form.AddTopicForm;
import com.chen.baida.form.UpdateActivityForm;
import com.chen.baida.form.UpdateTopicForm;
import com.chen.baida.model.QrActivity;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.*;

import java.util.List;

/** 管理后台业务逻辑
 * @author HanHongmin 2018-11-21
 */
public interface BackendAdminService {
    List<QrActivity> searchActivity(SearchActivityParam params);

    Long countActivity(SearchActivityParam params);

    List<Topic> searchTopic(SearchTopicParam params);

    Long countTopic(SearchTopicParam params);

    List<Feedback> searchFeedback(SearchFeedbackParam params);

    Long countFeedback(SearchFeedbackParam params);

    MessageVo deleteFeedback(String feedbackId);

    MessageVo deleteTopic(String topicId);

    MessageVo deleteActivity(String activityId);

    MessageVo addActivity(SharedUser curUser, AddActivityForm activityForm);

    MessageVo addTopic(SharedUser curUser, AddTopicForm topicForm);

    MessageVo updateActivity(SharedUser curUser, UpdateActivityForm activityForm);

    MessageVo updateTopic(SharedUser curUser, UpdateTopicForm topicForm);

    UpdateActivityForm getActivityById(String actId);

    UpdateTopicForm getTopicById(String topicId);

    List<CheckIn> searchCheckIn(SearchCheckInParam params);

    Long countCheckIn(SearchCheckInParam params);

    Long countAllCheckIn();

    Long countTodayCheckIn();

    Long countAllTopic();

    Long countAllFeedback();

    List<StringLongVo> chartSignInByHour();
}
