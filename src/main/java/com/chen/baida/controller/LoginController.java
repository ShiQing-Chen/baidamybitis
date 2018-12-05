package com.chen.baida.controller;

import com.chen.baida.form.UserInfoForm;
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

    /**
     * 手机验证码登录
     */
    @RequestMapping("/login/userInfo")
    public String userInfo(Model model, String r){
        UserInfoForm userInfoForm = new UserInfoForm();
        userInfoForm.setR(r);
        model.addAttribute("userInfoForm",userInfoForm);
        return "login/user-mobile";
    }

    /**
     * 手机验证码登录
     */
    @RequestMapping("/login/qrLogin")
    public String qrLogin(HttpServletRequest request, Model model, @Valid UserInfoForm userInfoForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            LOGGER.debug("########表单验证失败");
            model.addAttribute("userInfoForm",userInfoForm);
            //返回重新填写
            return "login/user-mobile";
        }
        MessageVo messageVo = loginService.qrLogin(request,userInfoForm);
        if(!messageVo.isSuccess()){
            model.addAttribute("resultTips", messageVo.getMessage());
            //返回重新填写
            return "login/user-mobile";
        }

        if(StringUtils.isNotBlank(userInfoForm.getR())){
            String redirectURL = new String(Base64.decodeBase64(userInfoForm.getR()));
            return "redirect:"+redirectURL;
        }else{
            return "error/error-mobile";
        }

    }


}
