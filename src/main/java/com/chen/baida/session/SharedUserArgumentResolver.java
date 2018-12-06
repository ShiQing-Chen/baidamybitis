package com.chen.baida.session;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 支持将SharedUser 作为controller 参数直接使用
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
public class SharedUserArgumentResolver implements HandlerMethodArgumentResolver {

	public boolean supportsParameter(MethodParameter parameter) {
		return SharedUser.class.isAssignableFrom(parameter.getParameterType());
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
		return SessionUtils.getCurUser(request);
	}

}
