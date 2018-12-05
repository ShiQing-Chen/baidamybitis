package com.chen.baida.service;

import com.chen.baida.form.UserInfoForm;
import com.chen.baida.vo.MessageVo;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录相关逻辑
 * @author HanHongmin 2018-11-12
 */
public interface LoginService {
    /**
     * 根据手机验证码登录
     * @param request 上下文请求
     * @param mobile 手机号码
     * @param password 手机验证码
     * @return 登录结果以及错误信息
     */
    MessageVo login(HttpServletRequest request, String mobile, String password);

    /**
     * 扫码填写信息登录，如果手机号存在则更新信息，不存在则添加一个用户
     * @param request 请求上下文
     * @param form 页面表单
     * @return 登录结果
     */
    MessageVo qrLogin(HttpServletRequest request, UserInfoForm form);
}
