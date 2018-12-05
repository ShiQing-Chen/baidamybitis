package com.chen.baida.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
@Component
public class HttpsRedirectFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpsRedirectFilter.class);
    private static final String HEAD_HTTPS = "x-forwarded-proto";
    private static final String HTTPS = "https";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("######## 初始化跳转处理器... ########");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if(HTTPS.equalsIgnoreCase(httpServletRequest.getHeader(HEAD_HTTPS))){
            filterChain.doFilter(request, new SendRedirectOverloadedResponse(httpServletRequest, httpServletResponse));
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        LOGGER.info("######## 销毁跳转处理器... ########");
    }
}
