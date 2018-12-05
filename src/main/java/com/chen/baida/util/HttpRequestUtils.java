package com.chen.baida.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/** 请求信息工具, 如获取客户端ip等
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
public class HttpRequestUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestUtils.class);
    private static final String UN_KNOWN = "unknown";
    private static final String HTTPS = "https";
    private HttpRequestUtils(){
        //empty
    }

    /**
     * 根据request 获取用户真实IP地址
     * @param request http 请求
     * @return ip 地址
     */
    public static String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (!StringUtils.hasText(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!StringUtils.hasText(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!StringUtils.hasText(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (!StringUtils.hasText(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (!StringUtils.hasText(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 判断是不是ajax请求
     * @param request request
     * @return 是不是ajax请求
     */
    public static boolean isAjax(HttpServletRequest request){
        //X-Requested-With XMLHttpRequest
        String headerValue = request.getHeader("x-requested-with");
        return headerValue != null && "XMLHttpRequest".equalsIgnoreCase(headerValue);
    }

    /**
     * 判断是不是在微信浏览器里的请求
     * @param request request
     * @return 是不是在微信浏览器里的请求
     */
    public static boolean isWeixin(HttpServletRequest request) {
        String headerValue = request.getHeader("user-agent");
        return headerValue != null && headerValue.toLowerCase().contains("micromessenger");
    }

    /**
     * 获取带上下文的基础路径
     * @param request 请求
     * @return 路径
     */
    public static String getBasePath(HttpServletRequest request){
        String appContext = request.getContextPath();
        StringBuilder basePath =  new StringBuilder();
        String scheme = request.getScheme();
        //对于在复杂均衡后面的服务的处理
        if(HTTPS.equalsIgnoreCase(request.getHeader("x-forwarded-proto"))){
            scheme = HTTPS;
        }
        basePath.append(scheme).append("://").append(request.getServerName());
        if(request.getServerPort()!=80){
            basePath.append(":").append(request.getServerPort());
        }
        basePath.append(appContext);
        return basePath.toString();
    }

    /**
     * 用户拦截器等功能，需要给出后续跳转参数的地方。计算跳转r 参数
     * @param request 请求
     * @return r 的参数值
     */
    public static String getRedirectParam(HttpServletRequest request){
        try {
            String url = request.getRequestURL().toString();
            if (HTTPS.equalsIgnoreCase(request.getHeader("x-forwarded-proto"))) {
                url = url.replaceFirst("http", HTTPS);
            }
            if (!CollectionUtils.isEmpty(request.getParameterMap())) {
                if (!url.contains("?")) {
                    url = url + "?";
                }

                url = buildParams(url,request);
                if (url.endsWith("&")) {
                    url = url.substring(0, url.length() - 1);
                }
            }
            return Base64.encodeBase64URLSafeString(url.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("######## 编码错误",e);
        }
        return null;
    }

    private static String buildParams(String url,HttpServletRequest request){
        StringBuilder urlSb = new StringBuilder(url);
        for (Map.Entry<String, String[]> e : request.getParameterMap().entrySet()) {
            String[] v = e.getValue();
            StringBuilder vv = new StringBuilder();
            for (int i = 0; i < v.length; i++) {
                if (i == 0) {
                    vv.append(v[i]);
                } else {
                    vv.append(",").append(v[i]);
                }
            }
            String p = e.getKey() + "=" + vv + "&";
            urlSb.append(p);
        }
        return urlSb.toString();
    }
}
