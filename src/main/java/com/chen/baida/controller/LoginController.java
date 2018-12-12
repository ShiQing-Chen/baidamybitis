package com.chen.baida.controller;

import com.chen.baida.service.LoginService;
import com.chen.baida.vo.MessageVo;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 后台管理员登陆
     */
    @RequestMapping("/login/doLogin")
    @ResponseBody
    public MessageVo doLogin(HttpServletRequest request, String mobile, String mobileCode){
        return loginService.login(request,mobile,mobileCode);
    }

}
