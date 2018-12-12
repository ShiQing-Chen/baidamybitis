package com.chen.baida.controller;


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


    /**
     * 默认首页
     */
    @RequestMapping(value = "/dashboard")
    public String dashboard(Device device,Model model){
        Long totalCheckIn = new Long(11);
        Long todayCheckIn = new Long(11);
        Long totalTopic = new Long(11);
        Long totalFeedback = new Long(11);
        model.addAttribute("totalCheckIn",totalCheckIn);
        model.addAttribute("todayCheckIn",todayCheckIn);
        model.addAttribute("totalTopic",totalTopic);
        model.addAttribute("totalFeedback",totalFeedback);
//        return device.isNormal()?"index/dashboard":"index/dashboard-mobile";
        return "index/dashboard";
    }


}
