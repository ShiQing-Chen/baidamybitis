package com.chen.baida.controller;

import com.chen.baida.util.HttpRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    /**
     * 默认首页
     */
    @RequestMapping(value = "/")
    public String index(HttpServletRequest request, String r, Model model, Device device){
        LOGGER.debug("#### 用户设备类型：电脑{}, 手机{}, 平板{}",device.isNormal(),device.isMobile(),device.isTablet());
        //跳转被拦截的地址，可能为空
        model.addAttribute("r",r);
        //判断浏览器是否是PC端
        if(device.isNormal()){
            model.addAttribute("deviceNormal",true);
            model.addAttribute("isWx",false);
            return "index/default";
        }else{
            //可能是手机也可能是平板（手机mobile, 平板tablet）
            model.addAttribute("deviceNormal",false);
            model.addAttribute("isWx", HttpRequestUtils.isWeixin(request));
            return "index/default-mobile";
        }
    }
}
