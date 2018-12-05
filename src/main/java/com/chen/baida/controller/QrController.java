package com.chen.baida.controller;

import com.chen.baida.dto.Topic;
import com.chen.baida.model.QrTopic;
import com.chen.baida.service.QrService;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
@Controller
public class QrController {

    private final QrService qrService;

    @Autowired
    public QrController(QrService qrService) {
        this.qrService = qrService;
    }

    /**
     * 扫码录入反馈
     */
    @RequestMapping("/qr/checkIn/{actId}")
    public String qrCheckId(SharedUser curUser, Model model, @PathVariable("actId") String actId){
        MessageVo messageVo = qrService.checkIn(curUser, actId);
        if(!messageVo.isSuccess()){
            return "error/error-mobile";
        }
        model.addAttribute("checkIn",true);
        return "redirect:/qr/topicList/"+actId;
    }

    /**
     * 活动主题列表
     */
    @RequestMapping("/qr/topicList/{actId}")
    public String topicList(SharedUser curUser, Model model, @PathVariable("actId") String actId){
        List<Topic> passedList = qrService.listPassedTopic(actId);
        List<Topic> todayUnPassedList = qrService.listUnPassedToday(actId);
        List<Topic> comingDaysList = qrService.listComingDays(actId);
        model.addAttribute("passedList",passedList);
        model.addAttribute("todayUnPassedList",todayUnPassedList);
        model.addAttribute("comingDaysList",comingDaysList);
        return "qr/topic-list-mobile";
    }

    /**
     * 扫码录入反馈
     */
    @RequestMapping("/qr/{topicId}")
    public String qrFeedback(Model model, @PathVariable("topicId") String topicId){
        QrTopic topic = qrService.getById(topicId);
        model.addAttribute("topic",topic);
        return "qr/feedback-mobile";
    }

    /**
     * 录入反馈
     */
    @RequestMapping("/qr/addFeedback/{topicId}")
    @ResponseBody
    public MessageVo qrAddFeedback(SharedUser curUser, @PathVariable("topicId") String topicId, Integer feedbackOption, String suggestion){
        return qrService.addFeedback(curUser, topicId, feedbackOption, suggestion);
    }

    /**
     * 录入反馈
     */
    @RequestMapping("/qr/success/{topicId}")
    public String success(Model model, @PathVariable("topicId") String topicId){
        QrTopic topic = qrService.getById(topicId);
        model.addAttribute("topic",topic);
        return "qr/success-mobile";
    }
}
