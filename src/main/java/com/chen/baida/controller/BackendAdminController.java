package com.chen.baida.controller;

import com.chen.baida.dto.CheckIn;
import com.chen.baida.dto.Feedback;
import com.chen.baida.dto.Topic;
import com.chen.baida.form.AddActivityForm;
import com.chen.baida.form.AddTopicForm;
import com.chen.baida.form.UpdateActivityForm;
import com.chen.baida.form.UpdateTopicForm;
import com.chen.baida.model.QrActivity;
import com.chen.baida.service.BackendAdminService;
import com.chen.baida.session.SharedUser;
import com.chen.baida.util.ServerInfoUtils;
import com.chen.baida.vo.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
@Controller
public class BackendAdminController {

    private final BackendAdminService backendAdminService;

    @Value("${system.qr.url.base}")
    private String qrUrlBase;

    @Value("${server.port}")
    private Integer serverPort;

    private final Environment environment;

    @Autowired
    public BackendAdminController(BackendAdminService backendAdminService, Environment environment) {
        this.backendAdminService = backendAdminService;
        this.environment = environment;
    }

    /**
     * 默认首页
     */
    @RequestMapping(value = "/dashboard")
    public String dashboard(Device device,Model model){
        Long totalCheckIn = backendAdminService.countAllCheckIn();
        Long todayCheckIn = backendAdminService.countTodayCheckIn();
        Long totalTopic = backendAdminService.countAllTopic();
        Long totalFeedback = backendAdminService.countAllFeedback();
        model.addAttribute("totalCheckIn",totalCheckIn);
        model.addAttribute("todayCheckIn",todayCheckIn);
        model.addAttribute("totalTopic",totalTopic);
        model.addAttribute("totalFeedback",totalFeedback);
//        return device.isNormal()?"index/dashboard":"index/dashboard-mobile";
        return "index/dashboard";
    }

    /**
     * 系统面板的累计签到图表
     */
    @RequestMapping(value = "/backend/chartSignIn")
    @ResponseBody
    public MessageVo chartSignIn(){
        List<StringLongVo> data = backendAdminService.chartSignInByHour();
        return new MessageVo(true,"获取成功", data);
    }

    /**
     * 活动列表
     */
    @RequestMapping(value = "/backend/activity")
    public String activity(Device device, Model model){
        Set<String> runEvn = Sets.newHashSet(environment.getActiveProfiles());
        if(runEvn.contains("prod")){
            model.addAttribute("qrUrlBase",qrUrlBase);
        }else{
            String devBaseUrl = "http://"+ ServerInfoUtils.getServerIp()+":"+serverPort;
            model.addAttribute("qrUrlBase",devBaseUrl);
        }
        return "backend/activity";
    }

    /**
     * 添加活动
     */
    @RequestMapping(value = "/backend/addActivity")
    public String addActivity(Model model){
        model.addAttribute("addActivityForm",new AddActivityForm());
        return "backend/activity-add";
    }

    /**
     * 添加活动
     */
    @RequestMapping(value = "/backend/doAddActivity")
    public String doAddActivity(SharedUser curUser, Model model, @Valid AddActivityForm addActivityForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("addActivityForm",addActivityForm);
            return "backend/activity-add";
        }
        MessageVo messageVo = backendAdminService.addActivity(curUser,addActivityForm);
        if(!messageVo.isSuccess()){
            model.addAttribute("addActivityForm",addActivityForm);
            model.addAttribute("errorMsg",messageVo.getMessage());
            return "backend/activity-add";
        }
        return "redirect:/backend/activity";
    }

    /**
     * 修改活动
     */
    @RequestMapping(value = "/backend/updateActivity/{actId}")
    public String updateActivity(Model model, @PathVariable String actId){
        UpdateActivityForm updateActivityForm = backendAdminService.getActivityById(actId);
        model.addAttribute("updateActivityForm", updateActivityForm);
        return "backend/activity-update";
    }

    /**
     * 添加活动
     */
    @RequestMapping(value = "/backend/doUpdateActivity")
    public String doUpdateActivity(SharedUser curUser, Model model, @Valid UpdateActivityForm updateActivityForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("updateActivityForm",updateActivityForm);
            return "backend/activity-update";
        }
        MessageVo messageVo = backendAdminService.updateActivity(curUser,updateActivityForm);
        if(!messageVo.isSuccess()){
            model.addAttribute("updateActivityForm",updateActivityForm);
            model.addAttribute("errorMsg",messageVo.getMessage());
            return "backend/activity-update";
        }
        return "redirect:/backend/activity";
    }

    /**
     * 主题列表
     */
    @RequestMapping(value = "/backend/topic")
    public String topic(Device device, Model model){
        Set<String> runEvn = Sets.newHashSet(environment.getActiveProfiles());
        if(runEvn.contains("prod")){
            model.addAttribute("qrUrlBase",qrUrlBase);
        }else{
            String devBaseUrl = "http://"+ ServerInfoUtils.getServerIp()+":"+serverPort;
            model.addAttribute("qrUrlBase",devBaseUrl);
        }

        return "backend/topic";
    }

    /**
     * 添加主题
     */
    @RequestMapping(value = "/backend/addTopic")
    public String addTopic(Model model){
        model.addAttribute("addTopicForm",new AddTopicForm());
        return "backend/topic-add";
    }

    /**
     * 添加主题
     */
    @RequestMapping(value = "/backend/doAddTopic")
    public String doAddTopic(SharedUser curUser, Model model, @Valid AddTopicForm addTopicForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("addTopicForm",addTopicForm);
            return "backend/topic-add";
        }
        MessageVo messageVo = backendAdminService.addTopic(curUser,addTopicForm);
        if(!messageVo.isSuccess()){
            model.addAttribute("addTopicForm",addTopicForm);
            model.addAttribute("errorMsg",messageVo.getMessage());
            return "backend/topic-add";
        }
        return "redirect:/backend/topic";
    }

    /**
     * 添加主题
     */
    @RequestMapping(value = "/backend/updateTopic/{topicId}")
    public String updateTopic(Model model, @PathVariable String topicId){
        UpdateTopicForm updateTopicForm = backendAdminService.getTopicById(topicId);
        model.addAttribute("updateTopicForm", updateTopicForm);
        return "backend/topic-update";
    }

    /**
     * 添加主题
     */
    @RequestMapping(value = "/backend/doUpdateTopic")
    public String doUpdateTopic(SharedUser curUser, Model model, @Valid UpdateTopicForm updateTopicForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("updateTopicForm",updateTopicForm);
            return "backend/topic-update";
        }
        MessageVo messageVo = backendAdminService.updateTopic(curUser,updateTopicForm);
        if(!messageVo.isSuccess()){
            model.addAttribute("updateTopicForm",updateTopicForm);
            model.addAttribute("errorMsg",messageVo.getMessage());
            return "backend/topic-update";
        }
        return "redirect:/backend/topic";
    }

    /**
     * 反馈列表
     */
    @RequestMapping(value = "/backend/feedback")
    public String feedback(Device device){
        return "backend/feedback";
    }

    /**
     * 活动列表数据
     */
    @RequestMapping(value = "/backend/searchActivity")
    @ResponseBody
    public Map<String,Object> searchActivity(@RequestBody SearchActivityParam params){
        Map<String,Object> map = Maps.newHashMap();
        Long total = backendAdminService.countActivity(params);
        List<QrActivity> data = backendAdminService.searchActivity(params);
        map.put("total",total);
        map.put("rows",data);
        return map;
    }

    /**
     * 主题列表数据
     */
    @RequestMapping(value = "/backend/searchTopic")
    @ResponseBody
    public Map<String,Object> searchTopic(@RequestBody SearchTopicParam params){
        Map<String,Object> map = Maps.newHashMap();
        Long total = backendAdminService.countTopic(params);
        List<Topic> data = backendAdminService.searchTopic(params);
        map.put("total",total);
        map.put("rows",data);
        return map;
    }

    /**
     * 反馈列表数据
     */
    @RequestMapping(value = "/backend/searchFeedback")
    @ResponseBody
    public Map<String,Object> searchFeedback(@RequestBody SearchFeedbackParam params){
        Map<String,Object> map = Maps.newHashMap();
        Long total = backendAdminService.countFeedback(params);
        List<Feedback> data = backendAdminService.searchFeedback(params);
        map.put("total",total);
        map.put("rows",data);
        return map;
    }

    /**
     * 删除反馈
     */
    @RequestMapping(value = "/backend/deleteFeedback")
    @ResponseBody
    public MessageVo deleteFeedback(String feedbackId){
        return backendAdminService.deleteFeedback(feedbackId);
    }

    /**
     * 删除主题
     */
    @RequestMapping(value = "/backend/deleteTopic")
    @ResponseBody
    public MessageVo deleteTopic(String topicId){
        return backendAdminService.deleteTopic(topicId);
    }

    /**
     * 删除活动
     */
    @RequestMapping(value = "/backend/deleteActivity")
    @ResponseBody
    public MessageVo deleteActivity(String activityId){
        return backendAdminService.deleteActivity(activityId);
    }

    /**
     * 活动检索提示
     */
    @RequestMapping(value = "/backend/activityTips")
    @ResponseBody
    public List<TipsVo> activityTips(String keyword){
        List<TipsVo> result = Lists.newArrayList();
        SearchActivityParam param = new SearchActivityParam();
        param.setLimit(10);
        param.setOffset(0);
        param.setSearch(keyword);
        List<QrActivity> data = backendAdminService.searchActivity(param);
        for (QrActivity act : data) {
            TipsVo vo = new TipsVo();
            vo.setId(act.getId());
            vo.setTipName(act.getActName());
            result.add(vo);
        }
        return result;
    }

    /**
     * 签到查询
     */
    @RequestMapping(value = "/backend/checkIn")
    public String checkIn(Device device){
        return "backend/check-in";
    }

    /**
     * 活动列表数据
     */
    @RequestMapping(value = "/backend/searchCheckIn")
    @ResponseBody
    public Map<String,Object> searchCheckIn(@RequestBody SearchCheckInParam params){
        Map<String,Object> map = Maps.newHashMap();
        Long total = backendAdminService.countCheckIn(params);
        List<CheckIn> data = backendAdminService.searchCheckIn(params);
        map.put("total",total);
        map.put("rows",data);
        return map;
    }
}
