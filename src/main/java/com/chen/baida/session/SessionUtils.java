package com.chen.baida.session;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**Session工具类, 与Session相关的常量等
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
public class SessionUtils {
    private static final String USER_IN_SESSION = "curUser";// 以后改成curUser

    private SessionUtils(){
        //default
    }
    /**
     * 获取当前登录用户
     * @param request HttpServletRequest
     * @return 当前登录用户
     */
    public static SharedUser getCurUser(final HttpServletRequest request){
        return (SharedUser) WebUtils.getSessionAttribute(request,USER_IN_SESSION);
    }

    /**
     * 设置当前登录用户
     * @param request HttpServletRequest
     * @param user 用户
     */
    public static void setCurUser(final HttpServletRequest request, final SharedUser user){
        WebUtils.setSessionAttribute(request, USER_IN_SESSION,user);
    }

    /**
     * 用于支持controller 中直接使用参数
     */
    public static SharedUser getCurUser(RequestAttributes attributes) {
        return (SharedUser) attributes.getAttribute(USER_IN_SESSION, RequestAttributes.SCOPE_SESSION);
    }
}
