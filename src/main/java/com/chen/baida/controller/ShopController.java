package com.chen.baida.controller;

import com.chen.baida.model.Shop;
import com.chen.baida.service.ShopService;
import com.chen.baida.vo.SearchShopParam;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ShiQing_Chen
 * @date 2018/12/12 17:08
 */
@Controller
public class ShopController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    /**
     * 活动列表
     */
    @RequestMapping(value = "/shop/shopList")
    public String activity(Device device, Model model){
//        Set<String> runEvn = Sets.newHashSet(environment.getActiveProfiles());
//        if(runEvn.contains("prod")){
//            model.addAttribute("qrUrlBase",qrUrlBase);
//        }else{
//            String devBaseUrl = "http://"+ ServerInfoUtils.getServerIp()+":"+serverPort;
//            model.addAttribute("qrUrlBase",devBaseUrl);
//        }
        return "/shop/shopList";
    }

    /**
     * 活动列表数据
     */
    @RequestMapping(value = "/shop/searchShop")
    @ResponseBody
    public Map<String,Object> searchActivity(@RequestBody SearchShopParam params){
        Map<String,Object> map = Maps.newHashMap();
        Long total = shopService.countShop(params);
//        List<Shop> data = shopService.searchShop(params);
        map.put("total",total);
        map.put("rows","");
        return map;
    }
}
