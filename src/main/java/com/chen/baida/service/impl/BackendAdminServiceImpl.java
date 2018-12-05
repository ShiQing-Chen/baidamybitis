package com.chen.baida.service.impl;

import com.chen.baida.dto.CheckIn;
import com.chen.baida.dto.Feedback;
import com.chen.baida.dto.Topic;
import com.chen.baida.form.AddActivityForm;
import com.chen.baida.form.AddTopicForm;
import com.chen.baida.form.UpdateActivityForm;
import com.chen.baida.form.UpdateTopicForm;
import com.chen.baida.mapper.QrActivityMapper;
import com.chen.baida.mapper.QrCheckInMapper;
import com.chen.baida.mapper.QrFeedbackMapper;
import com.chen.baida.mapper.QrTopicMapper;
import com.chen.baida.model.QrActivity;
import com.chen.baida.model.QrTopic;
import com.chen.baida.service.BackendAdminService;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author HanHongmin 2018-11-12
 */
@Service
public class BackendAdminServiceImpl implements BackendAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackendAdminServiceImpl.class);

    private final QrActivityMapper qrActivityMapper;
    private final QrTopicMapper qrTopicMapper;
    private final QrFeedbackMapper qrFeedbackMapper;
    private final QrCheckInMapper qrCheckInMapper;

    @Autowired
    public BackendAdminServiceImpl(QrActivityMapper qrActivityMapper,
                                   QrTopicMapper qrTopicMapper,
                                   QrFeedbackMapper qrFeedbackMapper,
                                   QrCheckInMapper qrCheckInMapper) {
        this.qrActivityMapper = qrActivityMapper;
        this.qrTopicMapper = qrTopicMapper;
        this.qrFeedbackMapper = qrFeedbackMapper;
        this.qrCheckInMapper = qrCheckInMapper;
    }

    @Override
    public List<QrActivity> searchActivity(SearchActivityParam params) {
        return qrActivityMapper.searchActivity(params);
    }

    @Override
    public Long countActivity(SearchActivityParam params) {
        return qrActivityMapper.countActivity(params);
    }

    @Override
    public List<Topic> searchTopic(SearchTopicParam params) {
        return qrTopicMapper.searchTopic(params);
    }

    @Override
    public Long countTopic(SearchTopicParam params) {
        return qrTopicMapper.countTopic(params);
    }

    @Override
    public List<Feedback> searchFeedback(SearchFeedbackParam params) {
        return qrFeedbackMapper.searchFeedback(params);
    }

    @Override
    public Long countFeedback(SearchFeedbackParam params) {
        return qrFeedbackMapper.countFeedback(params);
    }

    @Override
    public MessageVo deleteFeedback(String feedbackId) {
        int count = qrFeedbackMapper.deleteFeedback(feedbackId);
        return new MessageVo(count==1);
    }

    @Override
    public MessageVo deleteTopic(String topicId) {
        int count = qrTopicMapper.deleteTopic(topicId);
        return new MessageVo(count==1);
    }

    @Override
    public MessageVo deleteActivity(String activityId) {
        int count = qrActivityMapper.deleteActivity(activityId);
        return new MessageVo(count==1);
    }

    @Override
    public MessageVo addActivity(SharedUser curUser, AddActivityForm activityForm) {
        QrActivity activity = new QrActivity();
        BeanUtils.copyProperties(activityForm,activity);
        activity.setId(UUID.randomUUID().toString());
        activity.setCreateTime(new Date());
        activity.setCreatorId(curUser.getId());
        activity.setDeleted(false);

        int count = qrActivityMapper.addActivity(activity);
        return new MessageVo(count == 1);
    }

    @Override
    public MessageVo addTopic(SharedUser curUser, AddTopicForm topicForm) {
        QrTopic topic = new QrTopic();
        BeanUtils.copyProperties(topicForm,topic);
        topic.setCreateTime(new Date());
        topic.setCreatorId(curUser.getId());
        topic.setDeleted(false);
        topic.setId(UUID.randomUUID().toString());

        int count = qrTopicMapper.addTopic(topic);
        return new MessageVo(count == 1);
    }

    @Override
    public UpdateActivityForm getActivityById(String actId) {
        return qrActivityMapper.getUpdateFormById(actId);
    }

    @Override
    public UpdateTopicForm getTopicById(String topicId) {
        return qrTopicMapper.getUpdateFormById(topicId);
    }

    @Override
    public MessageVo updateActivity(SharedUser curUser, UpdateActivityForm activityForm) {
        QrActivity activity = qrActivityMapper.getById(activityForm.getId());
        BeanUtils.copyProperties(activityForm,activity,"id","createTime","creatorId","deleted");

        int count = qrActivityMapper.updateActivity(activity);
        return new MessageVo(count == 1);
    }

    @Override
    public MessageVo updateTopic(SharedUser curUser, UpdateTopicForm topicForm) {
        QrTopic topic = qrTopicMapper.getById(topicForm.getId());
        BeanUtils.copyProperties(topicForm,topic,"id","createTime","creatorId","deleted");

        int count = qrTopicMapper.updateTopic(topic);
        return new MessageVo(count == 1);
    }

    @Override
    public List<CheckIn> searchCheckIn(SearchCheckInParam params) {
        return qrCheckInMapper.searchCheckIn(params);
    }

    @Override
    public Long countCheckIn(SearchCheckInParam params) {
        return qrCheckInMapper.countCheckIn(params);
    }

    @Override
    public Long countAllCheckIn() {
        return qrCheckInMapper.countAll();
    }

    @Override
    public Long countTodayCheckIn() {
        DateTime now = DateTime.now();
        now = now.withTime(0,0,0,0);
        return qrCheckInMapper.countTodayCheckIn(now.toDate());
    }

    @Override
    public Long countAllTopic() {
        return qrTopicMapper.countAll();
    }

    @Override
    public Long countAllFeedback() {
        return qrFeedbackMapper.countAll();
    }

    @Override
    public List<StringLongVo> chartSignInByHour() {
        DateTime now = DateTime.now();
        DateTime todayStart = now.withTime(0,0,0,0);
        Long countBeforeToday = qrCheckInMapper.countBeforeTime(todayStart.toDate());
        int thisHour = now.hourOfDay().get();
        List<StringLongVo> byHour = qrCheckInMapper.groupByHourAfterTime(todayStart.toDate());
        Map<String,StringLongVo> dataByHour = Maps.newHashMap();
        for(StringLongVo it:byHour){
            dataByHour.put(it.getKey(),it);
        }

        List<StringLongVo> result = Lists.newArrayList();
        Long total = countBeforeToday;
        for(int i=0;i<=24;i++){
            StringLongVo data = new StringLongVo();
            data.setKey(String.valueOf(i));
            if(i<=thisHour){
                if(dataByHour.containsKey(String.valueOf(i))){
                    total = total + dataByHour.get(String.valueOf(i)).getNum();
                }
                data.setNum(total);
            }else{
                data.setNum(null);
            }
            result.add(data);
        }

        return result;
    }
}
