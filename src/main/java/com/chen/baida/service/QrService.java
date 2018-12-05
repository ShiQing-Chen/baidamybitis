package com.chen.baida.service;

import com.chen.baida.dto.Topic;
import com.chen.baida.model.QrTopic;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.MessageVo;

import java.util.List;

/**
 *  扫码相关业务逻辑
 * @author HanHongmin 2018-11-21
 */
public interface QrService {
    QrTopic getById(String topicId);

    MessageVo addFeedback(SharedUser curUser, String topicId, Integer feedbackOption, String suggestion);

    MessageVo checkIn(SharedUser curUser, String actId);

    /**
     * 已错过的
     * @param actId
     * @return
     */
    List<Topic> listPassedTopic(String actId);

    /**
     * 今天还未开始的
     * @param actId
     * @return
     */
    List<Topic> listUnPassedToday(String actId);

    /**
     * 未来几天的
     * @param actId
     * @return
     */
    List<Topic> listComingDays(String actId);
}
