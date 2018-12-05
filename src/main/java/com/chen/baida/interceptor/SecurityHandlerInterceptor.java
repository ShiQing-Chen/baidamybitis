package com.chen.baida.interceptor;

import com.chen.baida.session.SessionUtils;
import com.chen.baida.session.SharedUser;
import com.chen.baida.util.HttpRequestUtils;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查拦截器
 *
 * @author : HanHongmin
 * @since 0.0.1
 */
public class SecurityHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityHandlerInterceptor.class);

    /**
     * 一些不需要登录检查的url 匹配
     */
    public static final ImmutableList<String> URL_EXCLUDE_LIST = ImmutableList.of(
            "/",
            "/login/**",
            "/qr/**",//QrSecurityHandlerInterceptor 管
            "/test/**",
            "/error/**");

    private static final String URL_LOGIN = "/";

    @SuppressWarnings("Duplicates")
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        SharedUser curUser = SessionUtils.getCurUser(request);

        //成功，放行
        if (curUser == null) {
            LOGGER.debug("登录检查失败:{},是否ajax请求:{}", request.getRequestURL(), HttpRequestUtils.isAjax(request));
            if (HttpRequestUtils.isAjax(request)) {
                //需要登录，ajax请求的状态码改为401,
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return false;
            } else {
                String r = HttpRequestUtils.getRedirectParam(request);
                //非ajax直接跳转到登陆页
                response.sendRedirect(request.getContextPath() + URL_LOGIN + "?r=" + r);
                return false;
            }
        }
        return true;
    }
}
