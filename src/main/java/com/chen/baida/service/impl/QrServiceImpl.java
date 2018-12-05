package com.chen.baida.service.impl;

import com.chen.baida.dto.Topic;
import com.chen.baida.mapper.QrCheckInMapper;
import com.chen.baida.mapper.QrFeedbackMapper;
import com.chen.baida.mapper.QrTopicMapper;
import com.chen.baida.model.QrCheckIn;
import com.chen.baida.model.QrFeedback;
import com.chen.baida.model.QrTopic;
import com.chen.baida.service.QrService;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.MessageVo;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author HanHongmin 2018-11-12
 */
@Service
public class QrServiceImpl implements QrService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QrServiceImpl.class);
    private final QrTopicMapper qrTopicMapper;
    private final QrFeedbackMapper qrFeedbackMapper;
    private final QrCheckInMapper qrCheckInMapper;

    @Autowired
    public QrServiceImpl(QrTopicMapper qrTopicMapper,
                         QrFeedbackMapper qrFeedbackMapper,
                         QrCheckInMapper qrCheckInMapper) {
        this.qrTopicMapper = qrTopicMapper;
        this.qrFeedbackMapper = qrFeedbackMapper;
        this.qrCheckInMapper = qrCheckInMapper;
    }

    @Override
    public QrTopic getById(String topicId) {
        return qrTopicMapper.getById(topicId);
    }

    @Override
    public MessageVo addFeedback(SharedUser curUser, String topicId, Integer feedbackOption, String suggestion) {
        QrFeedback feedback = new QrFeedback();
        feedback.setId(UUID.randomUUID().toString());
        feedback.setCreateTime(new Date());
        feedback.setCreatorId(curUser.getId());
        feedback.setDeleted(false);
        feedback.setFeedbackOption(feedbackOption);
        if(StringUtils.isNotBlank(suggestion)){
            feedback.setSuggestion(suggestion.trim());
        }
        feedback.setTopicId(topicId);
        int count = qrFeedbackMapper.addFeedback(feedback);
        return new MessageVo(count == 1);
    }

    @Override
    public MessageVo checkIn(SharedUser curUser, String actId) {
        QrCheckIn checkIn = qrCheckInMapper.getCheckInByUserAndActId(curUser.getId(), actId);
        if(checkIn == null){
            checkIn = new QrCheckIn();
            checkIn.setId(UUID.randomUUID().toString());
            checkIn.setActId(actId);
            checkIn.setCreateTime(new Date());
            checkIn.setCreatorId(curUser.getId());
            checkIn.setDeleted(false);
            int count = qrCheckInMapper.addTopic(checkIn);
            return new MessageVo(count==1);
        }else{
            return new MessageVo(true,"已经签过");
        }

    }

    @Override
    public List<Topic> listPassedTopic(String actId) {
        return qrTopicMapper.listPassedTopic(actId,new Date());
    }

    @Override
    public List<Topic> listUnPassedToday(String actId) {
        DateTime now = DateTime.now();
        DateTime tomorrow = now.withTime(0,0,0,0).plusDays(1);
        return qrTopicMapper.listUnPassedToday(actId,new Date(),tomorrow.toDate());
    }

    @Override
    public List<Topic> listComingDays(String actId) {
        DateTime now = DateTime.now();
        DateTime tomorrow = now.withTime(0,0,0,0).plusDays(1);
        return qrTopicMapper.listComingDays(actId,tomorrow.toDate());
    }
}
