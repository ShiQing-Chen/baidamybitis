package com.chen.baida.service;


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
}
