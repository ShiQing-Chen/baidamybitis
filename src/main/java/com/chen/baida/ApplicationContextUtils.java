package com.chen.baida;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
	private static ApplicationContext context;
	private ApplicationContextUtils() {
        //empty
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtils.context = applicationContext;
	}

	public static <T> T getBean(Class<T> clazz){
		return context.getBean(clazz);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBeanById(String id){
		return (T) context.getBean(id);
	}

}
